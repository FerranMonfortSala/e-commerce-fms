package com.ecommerce.ferran;

import com.ecommerce.ferran.infrastructure.adapters.in.controller.dto.PriceDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
class PriceRestControllerTest {
    private static final Long BRAND_ID = 1L;
    private static final Long PRODUCT_ID = 35455L;

    @Autowired
    private MockMvc mockMvc;

    // Test 1: request a las 10:00 del día 14 del product 35455 para la brand 1 (ZARA)
    @Test
    void testGetPriceAt10AMOnJune14() throws Exception {
        String date = "2020-06-14T10:00:00";
        BigDecimal expectedPrice = new BigDecimal("35.50");
        Integer expectedPriceList = 1;

        String response = generateRequest(date);

        assertResponse(response, expectedPrice, expectedPriceList);
    }

    // Test 2: request a las 16:00 del día 14 del product 35455 para la brand 1 (ZARA)
    @Test
    void testGetPriceAt4PMOnJune14() throws Exception {
        String date = "2020-06-14T16:00:00";
        BigDecimal expectedPrice = new BigDecimal("25.45");
        Integer expectedPriceList = 2;

        String response = generateRequest(date);

        assertResponse(response, expectedPrice, expectedPriceList);
    }

    // Test 3: request a las 21:00 del día 14 del product 35455 para la brand 1 (ZARA)
    @Test
    void testGetPriceAt9PMOnJune14() throws Exception {
        String date = "2020-06-14T21:00:00";
        BigDecimal expectedPrice = new BigDecimal("35.50");
        Integer expectedPriceList = 1;

        String response = generateRequest(date);

        assertResponse(response, expectedPrice, expectedPriceList);
    }

    // Test 4: request a las 10:00 del día 15 del product 35455 para la brand 1 (ZARA)
    @Test
    void testGetPriceAt10AMOnJune15() throws Exception {
        String date = "2020-06-15T10:00:00";
        BigDecimal expectedPrice = new BigDecimal("30.50");
        Integer expectedPriceList = 3;

        String response = generateRequest(date);

        assertResponse(response, expectedPrice, expectedPriceList);
    }

    // Test 5: request a las 21:00 del día 16 del product 35455 para la brand 1 (ZARA)
    @Test
    void testGetPriceAt9PMOnJune16() throws Exception {
        String date = "2020-06-16T21:00:00";
        BigDecimal expectedPrice = new BigDecimal("38.95");
        Integer expectedPriceList = 4;

        String response = generateRequest(date);

        assertResponse(response, expectedPrice, expectedPriceList);
    }

    private String generateRequest(String date) throws Exception {
        return mockMvc.perform(get("/prices")
                        .param("brandId", String.valueOf(BRAND_ID))
                        .param("productId", String.valueOf(PRODUCT_ID))
                        .param("date", date))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    }

    private void assertResponse(String response, BigDecimal expectedPrice, Integer expectedPriceList) throws JsonProcessingException {
        PriceDto priceDto = new ObjectMapper().readValue(response, PriceDto.class);

        assertThat(priceDto.getProductId()).isEqualTo(PRODUCT_ID);
        assertThat(priceDto.getBrandId()).isEqualTo(BRAND_ID);
        assertThat(priceDto.getPriceList()).isEqualTo(expectedPriceList);
        assertThat(priceDto.getPrice()).isEqualTo(expectedPrice);
    }
}
