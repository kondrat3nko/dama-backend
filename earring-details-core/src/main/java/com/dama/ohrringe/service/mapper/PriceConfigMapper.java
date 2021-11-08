package com.dama.ohrringe.service.mapper;

import com.dama.ohrringe.domain.PriceConfig;
import com.dama.ohrringe.dto.PriceConfigRestDto;
import org.mapstruct.Mapper;

@Mapper
public interface PriceConfigMapper {

    PriceConfig restDtoToDomain(PriceConfigRestDto restDto);

    PriceConfigRestDto domainToRestDto(PriceConfig domain);

}
