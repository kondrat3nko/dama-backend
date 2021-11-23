package com.dama.ohrringe.service;

import com.dama.ohrringe.common.exception.ApplicationErrorStatus;
import com.dama.ohrringe.common.exception.ApplicationException;
import com.dama.ohrringe.domain.Authority;
import com.dama.ohrringe.domain.User;
import com.dama.ohrringe.repository.AuthorityRepository;
import com.dama.ohrringe.repository.UserRepository;
import com.dama.ohrringe.security.SecurityUtils;
import com.dama.ohrringe.security.UserRole;
import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.Status;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;
  private final AuthorityRepository authorityRepository;
  private final PasswordEncoder passwordEncoder;

  public Optional<User> getUserWithAuthorities() {
    return SecurityUtils.getCurrentUserLogin()
                        .flatMap(userRepository::findOneByLogin);
  }


  public User registerUser(User user, String password) {
    Authority defaultAuthority = Authority.builder()
                                          .name(UserRole.USER.getRoleName())
                                          .build();
    userRepository
        .findOneByLogin(user.getLogin())
        .ifPresent(existingUser -> {
          throw new ApplicationException(ApplicationErrorStatus.USER_ALREADY_EXIST, "User",
              existingUser.getLogin());
        });
    userRepository
        .findOneByEmailIgnoreCase(user.getEmail())
        .ifPresent(existingUser -> {
          throw new ApplicationException(ApplicationErrorStatus.EMAIL_ALREADY_EXIST, "User",
              existingUser.getEmail());
        });
    String encryptedPassword = passwordEncoder.encode(password);
    user.setPassword(encryptedPassword);
    if (user.getAuthorities().isEmpty()) {
      user.setAuthorities(Set.of(defaultAuthority));
    }
    userRepository.save(user);
    log.debug("Created Information for User: {}", user);
    return user;
  }
}
