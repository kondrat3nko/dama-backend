package com.dama.ohrringe.service.mapper;

import com.dama.ohrringe.domain.User;
import com.dama.ohrringe.dto.UserRestDto;
import org.mapstruct.Mapper;

//@Mapper
public interface UserMapper {
  User restDtoToDomain(UserRestDto restDto);
  UserRestDto domainToRestDto(User domain);

}
