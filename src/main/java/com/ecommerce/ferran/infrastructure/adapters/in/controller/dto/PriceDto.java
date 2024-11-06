package com.ecommerce.ferran.infrastructure.adapters.in.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PriceDto {
    private Long brandId;
    private Long productId;
    private int priceList;
    private String startDate;
    private String endDate;
    private BigDecimal price;
    private String currency;
}

