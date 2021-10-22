package com.dama.ohrringe.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@SuperBuilder
@Document("earring_details")
@NoArgsConstructor
public class EarringDetail extends AbstractAuditingEntity {

  @Id
  private String id;
  @NonNull
  @Indexed
  private String name;
  private String description;
  private String material;

  @Field("image_url")
  private String imageUrl;

  private String color;
  private double price;
}
