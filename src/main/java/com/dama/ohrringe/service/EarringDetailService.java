package com.dama.ohrringe.service;

import com.dama.ohrringe.domain.EarringDetail;
import com.dama.ohrringe.repository.EarringDetailRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class EarringDetailService {

    private EarringDetailRepository earringDetailRepository;

    public EarringDetail createEarringDetail(EarringDetail newEarringDetail){
        return earringDetailRepository.save(newEarringDetail);

    }

}
