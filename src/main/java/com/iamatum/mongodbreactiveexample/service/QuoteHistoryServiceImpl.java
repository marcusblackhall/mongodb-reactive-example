package com.iamatum.mongodbreactiveexample.service;

import com.iamatum.mongodbreactiveexample.domain.QuoteHistory;
import com.iamatum.mongodbreactiveexample.model.Quote;
import com.iamatum.mongodbreactiveexample.repositories.QuoteHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuoteHistoryServiceImpl implements QuoteHistoryService {

    private final QuoteHistoryRepository quoteHistoryRepository;

    @Override
    public Mono<QuoteHistory> saveQuoteToMongo(Quote quote) {
        return quoteHistoryRepository.save(QuoteHistory.builder()
                .ticker(quote.getTicker())
                .price(quote.getPrice())
                        .instant(quote.getInstant())
                .build());
    }
}
