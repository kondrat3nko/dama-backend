package com.dama.ohrringe.service.mapper;

import com.dama.ohrringe.domain.Earring;
import com.dama.ohrringe.dto.EarringRestDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface EarringMapper {

    Earring restDtoToDomain(EarringRestDto restDto);

    EarringRestDto domainToRestDto(Earring domain);

    List<Earring> restDtoToDomain(List<EarringRestDto> restDto);

    List<EarringRestDto> domainToRestDto(List<Earring> domain);
}
