package com.example.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 import jakarta.validation.constraints.NotBlank;
 import jakarta.validation.constraints.Pattern;
  
@Entity
@Table(name = "categories")
public class Category {
 
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
 
    @NotBlank(message = "Description is mandatory")
    private String description ;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}  
 