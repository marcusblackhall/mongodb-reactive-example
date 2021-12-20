package com.iamatum.mongodbreactiveexample.service;

import com.iamatum.mongodbreactiveexample.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {

    Flux<Quote> fetchQuoteStream(Duration period);
}
