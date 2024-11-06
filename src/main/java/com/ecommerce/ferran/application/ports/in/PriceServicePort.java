package com.ecommerce.ferran.application.ports.in;

import com.ecommerce.ferran.domain.model.Price;
import java.time.LocalDateTime;

public interface PriceServicePort {
    Price getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate);
}
