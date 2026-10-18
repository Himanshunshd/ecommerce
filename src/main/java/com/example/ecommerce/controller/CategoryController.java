package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entity.Category;
import com.example.ecommerce.dto.CategoryNameUpdate;
import com.example.ecommerce.service.CategoryService; 

import jakarta.validation.Valid;

@RestController
public class CategoryController {
    
    private final CategoryService service ;   

        public CategoryController(CategoryService service){   
            this.service = service ;
        }
 
    @PostMapping("/categories")   // API -> Add Category 
    public String addCategory( @Valid @RequestBody Category categoryVar){   
        return service.addCategory(categoryVar) ;       
    }

    @GetMapping("/categories")   // API -> View Category 
    public List <Category> getCategory(){    
        return service.getCategory();       
    }

    @GetMapping("/categories/{id}")   // API -> View Category by id.
    public Category getCategoryByid( @PathVariable Long id){    
        return service.getCategoryByid(id) ;
    }
 
    @PutMapping("/categories/{id}")   // API -> Update Category by id.
    public String updateCategory ( @PathVariable Long id , @Valid @RequestBody Category categoryVar) {
        return service.updateCategory(id , categoryVar) ;
    }

    @PatchMapping("/categories/{id}")   // API -> partile Update Category by name.
    public String updatePartileCategory ( @PathVariable Long id , @Valid @RequestBody CategoryNameUpdate categoryVar) {
        return service.updatePartileCategory(id , categoryVar) ;
    } 

    @DeleteMapping("/categories/{id}")    // API -> delete Category.
    public String deleteCategory ( @PathVariable Long id ) {
        return service.deleteCategory(id); 
    }

}
