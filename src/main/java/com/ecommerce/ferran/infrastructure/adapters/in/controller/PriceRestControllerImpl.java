package com.ecommerce.ferran.infrastructure.adapters.in.controller;

import com.ecommerce.ferran.application.ports.in.PriceServicePort;
import com.ecommerce.ferran.infrastructure.adapters.in.controller.dto.PriceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceRestControllerImpl implements PriceRestController {

    private final PriceServicePort priceService;

    public PriceRestControllerImpl(PriceServicePort priceService) {
        this.priceService = priceService;
    }

    @Override
    @GetMapping
    public ResponseEntity<PriceDto> getPrice(@RequestParam Long brandId,
                             @RequestParam Long productId,
                             @RequestParam LocalDateTime date
    ) {
        return ResponseEntity.ok(priceService.getApplicablePrice(brandId, productId, date));
    }

}