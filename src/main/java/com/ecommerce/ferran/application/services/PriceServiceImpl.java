package com.ecommerce.ferran.application.services;

import com.ecommerce.ferran.application.ports.in.PriceServicePort;
import com.ecommerce.ferran.domain.exception.PriceNotFoundException;
import com.ecommerce.ferran.application.ports.out.PriceRepositoryPort;
import com.ecommerce.ferran.infrastructure.adapters.in.controller.dto.PriceDto;
import com.ecommerce.ferran.infrastructure.adapters.in.controller.mapper.PriceDtoMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements PriceServicePort {
    private final PriceRepositoryPort priceRepository;

    public PriceServiceImpl(final PriceRepositoryPort priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceDto getApplicablePrice(final Long brandId, final Long productId, final LocalDateTime applicationDate) {
        return priceRepository.findApplicablePrice(brandId, productId, applicationDate)
                .map(PriceDtoMapper.INSTANCE::priceToPriceDTO)
                .orElseThrow(() -> new PriceNotFoundException("Price not found in database"));
    }
}
