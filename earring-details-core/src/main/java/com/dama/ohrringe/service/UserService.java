package com.dama.ohrringe.service;

import com.dama.ohrringe.domain.Authority;
import com.dama.ohrringe.domain.User;
import com.dama.ohrringe.repository.AuthorityRepository;
import com.dama.ohrringe.repository.UserRepository;
import com.dama.ohrringe.security.SecurityUtils;
import java.time.Instant;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {
  private final UserRepository userRepository;
  private final AuthorityRepository authorityRepository;

  public Optional<User> getUserWithAuthorities() {
    return SecurityUtils.getCurrentUserLogin().flatMap(userRepository::findOneByLogin);
  }


}
