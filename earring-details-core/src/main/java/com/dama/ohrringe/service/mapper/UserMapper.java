package com.dama.ohrringe.service.mapper;

import com.dama.ohrringe.domain.Authority;
import com.dama.ohrringe.domain.User;
import com.dama.ohrringe.dto.UserRestDto;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.Qualifier;

@Mapper
public interface UserMapper {
  @Mappings({
      @Mapping(target = "authorities", source = "authorities", qualifiedByName = "authoritiesDomain")
  })
  User restDtoToDomain(UserRestDto restDto);

  @Mappings({
      @Mapping(target = "authorities", source = "authorities", qualifiedByName = "authoritiesRestDto")
  })
  UserRestDto domainToRestDto(User domain);

  @Named("authoritiesDomain")
  static Set<Authority> authoritiesDomain(Set<String> authorities) {
    Set<Authority> result = new HashSet<>();

    if (authorities != null) {
      result =
          authorities
              .stream()
              .map(s -> Authority.builder().name(s).build())
              .collect(Collectors.toSet());
    }
    return result;
  }

  @Named("authoritiesRestDto")
  static Set<String> authoritiesRestDto(Set<Authority> authorities){
    return authorities.stream().map(Authority::getName).collect(Collectors.toSet());
  }

}
