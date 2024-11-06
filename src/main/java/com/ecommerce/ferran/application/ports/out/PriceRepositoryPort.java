package com.ecommerce.ferran.application.ports.out;

import com.ecommerce.ferran.domain.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {
    Optional<Price> findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate);
}
