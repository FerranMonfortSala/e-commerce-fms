package com.ecommerce.ferran.infrastructure.adapters.out.database;

import com.ecommerce.ferran.domain.model.Price;
import com.ecommerce.ferran.application.ports.out.PriceRepositoryPort;
import com.ecommerce.ferran.infrastructure.adapters.out.database.mapper.PriceMapper;
import com.ecommerce.ferran.infrastructure.adapters.out.database.jpa.JpaPriceRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class PriceRepositoryImpl implements PriceRepositoryPort {
    private final JpaPriceRepository repository;

    public PriceRepositoryImpl(JpaPriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Price> findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return repository.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                        brandId, productId, applicationDate, applicationDate).map(PriceMapper.INSTANCE::toDomain);
    }
}
