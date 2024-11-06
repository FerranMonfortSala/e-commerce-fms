package com.ecommerce.ferran.infrastructure.adapters.in.controller.mapper;

import com.ecommerce.ferran.domain.model.Price;
import com.ecommerce.ferran.infrastructure.adapters.in.controller.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceDtoMapper {
    PriceDtoMapper INSTANCE = Mappers.getMapper(PriceDtoMapper.class);
    PriceDto priceToPriceDTO(Price price);
}

