package com.example.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    } 
    
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "[A-Za-z ]+", message = "Name must contain only letters and spaces")
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Price is mandatory")   // not null. It works with objects such as Integer, BigDecimal, and String.
    @Positive(message = "Price must be greater than 0")   //A number must be > 0.
    private BigDecimal price ;   // important

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = "Quantity is mandatory")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;   //int → default value is 0 , Integer → wrapper class(default value is null). Problem -> If the API request doesn't include quantity, Java may assign 0, and @Min(1) rejects it. @NotNull remove that null
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @NotBlank(message = "Description is mandatory")
    private String description ;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
