package com.ecommerce.ferran.infrastructure.adapters.out.database.mapper;

import com.ecommerce.ferran.domain.model.Price;
import com.ecommerce.ferran.infrastructure.adapters.out.database.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
    Price toDomain(PriceEntity priceEntity);
    PriceEntity toEntity(Price price);
}
