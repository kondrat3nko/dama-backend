package com.dama.ohrringe.service.mapper;

import com.dama.ohrringe.domain.EarringDetail;
import com.dama.ohrringe.service.dto.EarringDetailRestDto;
import org.mapstruct.Mapper;

@Mapper
public interface EarringDetailMapper {

    EarringDetail restDtoToDomain (EarringDetailRestDto restDto);
    EarringDetailRestDto domainToRestDto (EarringDetail domain);
}
