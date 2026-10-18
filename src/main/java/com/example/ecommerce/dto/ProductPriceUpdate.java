package com.example.ecommerce.dto;

import java.math.BigDecimal; 
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductPriceUpdate {    //DTO: defines validation rules for the specific request
    
    @NotNull @Positive private BigDecimal price;    // Why repeat the same rules? Because the DTO is a separate Java class.The validation annotations on Product are not automatically inherited by ProductPriceUpdate
        public BigDecimal getPrice() {
        return price;
    }
        public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
