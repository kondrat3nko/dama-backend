package com.dama.ohrringe.dto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/api")
@Tag(name = "Earring Details", description = "Working with details for earrings")
public interface EarringDetailApi {

    @Operation(
            summary = "Get all details",
            description = "Get all details for earrings"
    )
    @GetMapping
    ResponseEntity<List<EarringDetailRestDto>> getAllEarringDetails();

    @Operation(
            summary = "Add/update detail",
            description = "Add/update detail for earrings. For update parameter \"id\" is required"
    )
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    ResponseEntity<EarringDetailRestDto> postEarringDetail(@RequestBody @Parameter(description = "new detail") EarringDetailRestDto earringDetailRestDto);

    @Operation(
            summary = "Delete by id",
            description = "Delete earring detail by id"
    )
    @DeleteMapping("/earring/{id}")
    ResponseEntity<Void> deleteById(@Parameter(description = "id detail", example = "60a819945ad3b32b9cf31c64") @PathVariable("id") String id);



}
