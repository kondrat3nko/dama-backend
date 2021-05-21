package com.dama.ohrringe.service;

import com.dama.ohrringe.common.exception.ApplicationException;
import com.dama.ohrringe.domain.EarringDetail;
import com.dama.ohrringe.repository.EarringDetailRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.dama.ohrringe.common.exception.ApplicationErrorStatus.ENTITY_NOT_FOUND;
import static com.dama.ohrringe.common.exception.ApplicationErrorStatus.FAILED_DELETE_ENTITY;

@Slf4j
@AllArgsConstructor
@Service
public class EarringDetailService {

    private EarringDetailRepository earringDetailRepository;

    public EarringDetail createEarringDetail(EarringDetail newEarringDetail){
        return earringDetailRepository.save(newEarringDetail);

    }

    public List<EarringDetail> findAllEarringDetails(){
        return earringDetailRepository.findAll();
    }

    public Optional<EarringDetail> findEarringDetailsById(String id){
        return earringDetailRepository.findById(id);
    }

    public void deleteById(String id){
        if (!earringDetailRepository.existsById(id)){
            log.error("Earring details with id {} not found", id);
            throw new ApplicationException(ENTITY_NOT_FOUND, "earring details", id);
        }
        earringDetailRepository.deleteById(id);
    }


}
