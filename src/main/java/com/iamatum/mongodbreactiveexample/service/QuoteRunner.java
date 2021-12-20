package com.iamatum.mongodbreactiveexample.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
@Slf4j
public class QuoteRunner implements CommandLineRunner {
    private final QuoteGeneratorService quoteGeneratorService;
    private final QuoteHistoryService quoteHistoryService;

    @Override
    public void run(String... args) throws Exception {

        quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(100l))
                .take(50)
                .log("Got quote")
                .flatMap(quoteHistoryService::saveQuoteToMongo)
                .subscribe(savedQuote -> {
                            log.debug("Saved quote : {}", savedQuote);
                        },
                        throwable -> {
                            log.error("error {}", throwable);
                        },
                        () -> {
                            log.debug("all done");
                        }

                );

    }
}
