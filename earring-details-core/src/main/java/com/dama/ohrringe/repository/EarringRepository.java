package com.dama.ohrringe.repository;

import com.dama.ohrringe.domain.Earring;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the {@link Earring} entity.
 */
@Repository
public interface EarringRepository extends MongoRepository<Earring, String> {

  Optional<Earring> findOneByName(String name);
}
