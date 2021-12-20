package com.iamatum.mongodbreactiveexample.service;

import com.iamatum.mongodbreactiveexample.domain.QuoteHistory;
import com.iamatum.mongodbreactiveexample.model.Quote;
import reactor.core.publisher.Mono;

public interface QuoteHistoryService {

    Mono<QuoteHistory> saveQuoteToMongo(Quote quote);
}
