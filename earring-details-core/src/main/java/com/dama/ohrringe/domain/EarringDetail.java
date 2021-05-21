package com.dama.ohrringe.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document("earring_details")
public class EarringDetail {
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
