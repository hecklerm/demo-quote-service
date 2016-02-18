package org.thehecklers.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.thehecklers.entity.Quote;
import org.thehecklers.entity.QuoteSource;

import java.util.List;

/**
 * Created by markheckler on 11/24/15.
 */
@RepositoryRestResource
public interface QuoteRepo extends CrudRepository<Quote, Integer> {
    @Query("select quote from Quote quote order by RAND()")
    public List<Quote> randomQuotes();

    List<Quote> findByQuoteSource(@Param("source") QuoteSource source);
}
