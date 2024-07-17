package by.gurinovich.productservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public record Product(

        Long id,

        String name,

        String description,

        String applying,

        @JsonProperty(value = "original_price")
        BigDecimal originalPrice,

        @JsonProperty(value = "original_currency")
        String originalCurrency,

        String size,

        @JsonProperty(value = "measurement_type_id")
        Long measurementTypeId,

        String units,

        @JsonProperty(value = "product_category")
        ProductCategory category,

        List<ImageResponse> images


        ) {
}
