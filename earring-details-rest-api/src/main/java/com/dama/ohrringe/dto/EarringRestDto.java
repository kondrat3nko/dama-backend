package com.dama.ohrringe.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Schema(description = "Entity for earring")
public class EarringRestDto {
    @Schema(description = "id earring", example = "60a819945ad3b32b9cf31c64")
    private String id;
    @Schema(description = "name earring", example = "Cool earring")
    private String name;
    @Schema(description = "description earring", example = "earring for woman")
    private String description;
    @Schema(description = "name file for image", example = "Verschluss_1.jpg")
    private String imageUrl;
    private List<EarringDetailRestDto> earringDetails;
    @Schema(description = "price details", example = "20")
    private Double priceDetails;
    @Schema(description = "premium price", example = "5")
    private Double premium;
    @Schema(description = "Total price earring", example = "25")
    private Double totalPrice;
}
