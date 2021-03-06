package com.dama.ohrringe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.Instant;

/**
 * Base abstract class for entities which will hold definitions for created, last modified, created
 * by, last modified by attributes.
 */
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class AbstractAuditingEntity implements Serializable {

  @CreatedBy
  @Field("created_by")
  @JsonIgnore
  private String createdBy;

  @CreatedDate
  @Field("created_date")
  @JsonIgnore
  private Instant createdDate = Instant.now();

  @LastModifiedBy
  @Field("last_modified_by")
  @JsonIgnore
  private String lastModifiedBy;

  @LastModifiedDate
  @Field("last_modified_date")
  @JsonIgnore
  private Instant lastModifiedDate = Instant.now();
}
