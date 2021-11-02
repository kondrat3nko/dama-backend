package com.dama.ohrringe.domain;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@SuperBuilder
@NoArgsConstructor
@Document("earrings")
public class Earring extends AbstractAuditingEntity{

  @Id
  private String id;
  private String name;
  private String description;
  @Field("image_url")
  private String imageUrl;
  @DBRef
  private List<EarringDetail> earringDetails;

}
