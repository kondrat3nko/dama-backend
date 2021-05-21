package com.dama.ohrringe.service.mapper;

import com.dama.ohrringe.domain.EarringDetail;
import com.dama.ohrringe.dto.EarringDetailRestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EarringDetailMapper {

    EarringDetail restDtoToDomain(EarringDetailRestDto restDto);

    EarringDetailRestDto domainToRestDto(EarringDetail domain);

    List<EarringDetail> restDtoToDomain(List<EarringDetailRestDto> restDto);

    List<EarringDetailRestDto> domainToRestDto(List<EarringDetail> domain);
}
