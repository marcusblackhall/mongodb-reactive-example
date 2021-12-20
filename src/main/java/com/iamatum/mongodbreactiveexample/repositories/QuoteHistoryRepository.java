package com.iamatum.mongodbreactiveexample.repositories;

import com.iamatum.mongodbreactiveexample.domain.QuoteHistory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuoteHistoryRepository extends ReactiveMongoRepository<QuoteHistory,String> {
}
