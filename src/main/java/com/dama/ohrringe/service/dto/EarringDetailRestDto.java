package com.dama.ohrringe.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EarringDetailRestDto {
    private String name;
    private String description;
    private String material;
    private String imageUrl;
    private String color;
    private double price;
}
