package org.thehecklers.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.thehecklers.entity.QuoteSource;

/**
 * Created by markheckler on 11/24/15.
 */
@RepositoryRestResource
public interface QuoteSourceRepo extends CrudRepository<QuoteSource, Integer> {
}
