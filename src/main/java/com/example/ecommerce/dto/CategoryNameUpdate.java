package com.example.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryNameUpdate {
    
    @NotBlank private String name;    
        public String getName() {
        return name;
    }
        public void setName(String name) {
        this.name = name;
    } 
}
 