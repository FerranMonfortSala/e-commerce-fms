package com.ecommerce.ferran.application.ports.in;

import com.ecommerce.ferran.infrastructure.adapters.in.controller.dto.PriceDto;
import java.time.LocalDateTime;

public interface PriceServicePort {
    PriceDto getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate);
}
