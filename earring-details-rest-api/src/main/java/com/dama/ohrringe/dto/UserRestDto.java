package com.dama.ohrringe.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.Instant;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@Schema(description = "Entity for user")
public class UserRestDto {
  private String id;
  private String login;
  private String firstName;
  private String lastName;
  private String email;
  private String imageUrl;
  private boolean activated = false;
  private String langKey;
  private String createdBy;
  private Instant createdDate;
  private String lastModifiedBy;
  private Instant lastModifiedDate;
  private Set<String> authorities;

}
