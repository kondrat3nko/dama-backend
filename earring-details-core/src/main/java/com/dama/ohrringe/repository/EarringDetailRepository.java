package com.dama.ohrringe.repository;

import com.dama.ohrringe.domain.EarringDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/** Spring Data MongoDB repository for the {@link EarringDetail} entity. */
@Repository
public interface EarringDetailRepository extends MongoRepository<EarringDetail, String> {
    Optional<EarringDetail> findOneByName(String name);
}
