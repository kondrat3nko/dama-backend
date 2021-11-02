package com.dama.ohrringe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@Document("price_config")
@NoArgsConstructor
public class PriceConfig extends AbstractAuditingEntity{
  @Id
  private String id;

  @NonNull
  private double premiumRate;
}
