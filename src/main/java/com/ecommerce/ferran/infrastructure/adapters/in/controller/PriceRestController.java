package com.ecommerce.ferran.infrastructure.adapters.in.controller;

import com.ecommerce.ferran.domain.model.Price;
import com.ecommerce.ferran.infrastructure.adapters.in.controller.dto.PriceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Tag(name="Product prices", description = "Product prices Api specification")
public interface PriceRestController {
    @Operation(summary = "Get applicable price",
            description = "Get the applicable price for a product of a brand based on the date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Price found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Price.class)) }),
            @ApiResponse(responseCode = "404", description = "Price not found",
                    content = @Content)
    })
    @GetMapping
    PriceDto getPrice(@RequestParam Long brandId,
                      @RequestParam Long productId,
                      @Parameter(description = "Date in the format yyyy-MM-dd'T'HH:mm:ss", example = "2020-06-14T14:30:00") @RequestParam LocalDateTime date
    );
}
