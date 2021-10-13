package com.dama.ohrringe.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Constants for Spring Security authorities.
 */

@AllArgsConstructor
@Getter
public enum UserRole {

  ADMIN("ROLE_ADMIN"),
  USER("ROLE_USER"),
  ANONYMOUS("ROLE_ANONYMOUS");

  String roleName;
}
