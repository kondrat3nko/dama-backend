package com.dama.ohrringe.repository;

import com.dama.ohrringe.domain.EarringDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EarringDetailRepository extends MongoRepository<EarringDetail, String> {
    Optional<EarringDetail> findOneByName(String name);
}
