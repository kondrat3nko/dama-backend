package com.dama.ohrringe.web.rest;

import com.dama.ohrringe.common.exception.ApplicationErrorStatus;
import com.dama.ohrringe.common.exception.ApplicationException;
import com.dama.ohrringe.domain.User;
import com.dama.ohrringe.dto.UserRestDto;
import com.dama.ohrringe.service.UserService;
import com.dama.ohrringe.service.mapper.UserMapper;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

  private final UserService userService;
  UserMapper mapper = Mappers.getMapper(UserMapper.class);

  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * {@code GET  /authenticate} : check if the user is authenticated, and return its login.
   *
   * @param request the HTTP request.
   * @return the login if the user is authenticated.
   */
  @GetMapping("/authenticate")
  public String isAuthenticated(HttpServletRequest request) {
    log.debug("REST request to check if the current user is authenticated");
    return request.getRemoteUser();
  }

  @GetMapping("/account")
  public UserRestDto getAccount() {
    return userService
        .getUserWithAuthorities()
        .map(user -> mapper.domainToRestDto(user))
        .orElseThrow(() -> new ApplicationException(ApplicationErrorStatus.ENTITY_ALREADY_EXIST));
  }

}
