package com.dama.ohrringe.web.rest;

import com.dama.ohrringe.dto.LoginVM;
import com.dama.ohrringe.security.jwt.JWTFilter;
import com.dama.ohrringe.security.jwt.TokenProvider;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to authenticate users.
 */
@RestController
public class UserJWTController {
  private final AuthenticationManagerBuilder authenticationManagerBuilder;
  private final TokenProvider tokenProvider;

  public UserJWTController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
    this.authenticationManagerBuilder = authenticationManagerBuilder;
    this.tokenProvider = tokenProvider;
  }

  @PostMapping("/authenticate")
  @CrossOrigin
  public ResponseEntity<JWTToken> authorize(@Valid @RequestBody LoginVM loginVM) {
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
        loginVM.getUsername(),
        loginVM.getPassword()
    );

    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = tokenProvider.createToken(authentication);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
    return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);
  }

  /**
   * Object to return as body in JWT Authentication.
   */
  static class JWTToken {

    private String idToken;

    JWTToken(String idToken) {
      this.idToken = idToken;
    }

    @JsonProperty("id_token")
    String getIdToken() {
      return idToken;
    }

    void setIdToken(String idToken) {
      this.idToken = idToken;
    }
  }

}
