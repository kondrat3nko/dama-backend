package com.dama.ohrringe.web.rest;

import com.dama.ohrringe.domain.EarringDetail;
import com.dama.ohrringe.service.EarringDetailService;
import com.dama.ohrringe.service.dto.EarringDetailRestDto;
import com.dama.ohrringe.service.mapper.EarringDetailMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EarringDetailController {
    EarringDetailService earringDetailService;

    @GetMapping("/add")
    public String isAuthenticated(HttpServletRequest request) {
        EarringDetailMapper mapper = Mappers.getMapper(EarringDetailMapper.class);
        EarringDetailRestDto earringDetailRestDto = EarringDetailRestDto.builder()
                                                                        .name("Testig 1")
                                                                        .description("descrip")
                                                                        .price(2.5)
                                                                        .build();
        EarringDetail earringDetail = earringDetailService.createEarringDetail(mapper.restDtoToDomain(earringDetailRestDto));

//        return mapper.domainToRestDto(earringDetail).toString();
        return earringDetail.toString();
    }
}
