package com.example.ecommerce.dto;
import java.math.BigDecimal;

    public class ProductResponse {
    
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private BigDecimal price;

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        private Integer quantity;

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private Long categoryId;

        public Long getCategoryId() {
            return categoryId;
        }   

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }

        private String categoryName;

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

    }
