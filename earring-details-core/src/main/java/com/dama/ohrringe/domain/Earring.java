package com.dama.ohrringe.domain;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@NoArgsConstructor
@Document("earrings")
public class Earring extends AbstractAuditingEntity{

  @Id
  private String id;

  private List<EarringDetail> earringDetails;

}