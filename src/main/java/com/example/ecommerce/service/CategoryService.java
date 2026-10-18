package com.example.ecommerce.service;

import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CategoryNameUpdate;
import com.example.ecommerce.entity.Category; 
import com.example.ecommerce.exception.CategoryNotFoundException;
import com.example.ecommerce.repository.CategoryRepository; 

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    private final CategoryRepository repository;   // Ex. - Student stu1 = new Student() ; [CategoryRepository - Class Name HAI]

    public CategoryService(CategoryRepository repository) {  
        this.repository = repository;
    }

    public String addCategory (Category categoryVar) {    // API - Add Category handle.

        if( categoryVar.getId() != null )  {     // null nahi hai means user ne id diya hai.
            return "Client must not provide a category ID";
        }
        else {   // null hai matlab spring ne id generate kiya hai.
        repository.save(categoryVar);    
        return "Category Added Successfully.";
        }
    }

    public List <Category> getCategory() {                        // API - Get Category handle.
        List <Category> categoriesList = repository.findAll();   
        return categoriesList;
    }

    public Category getCategoryByid(Long id){                      // API - Get Category handle by id.
        Optional <Category> getId = repository.findById(id) ;
        return getId.orElseThrow ( () -> new CategoryNotFoundException ("Category not found with id: " + id) );
    }
 
    public String updateCategory(Long id , Category categoryVar){     // API - update Category Handler.
        if( categoryVar.getId() != null )  {
            return "Client must not provide a category ID";
        }
        else {
            if( repository.existsById(id) ){
                categoryVar.setId(id) ;
                repository.save(categoryVar) ;
                return "Category Updated Successfully" ;
            } else {
                return "Please Enter Valid Id" ;
            }
        }
    } 
     
    public String updatePartileCategory(Long id , CategoryNameUpdate categoryVar){     // API - update Category handle by Name.
          
        Optional <Category> existing = repository.findById(id); 
            if ( existing.isPresent() ) {        
                Category existingCategory = existing.get();          
                existingCategory.setName (categoryVar.getName() );    

                repository.save(existingCategory);
                return "Category Updated Successfully.";
            } else {
                return "Id Doesn't Found";
                }
    }   

    public String deleteCategory(Long id) {

        if (!repository.existsById(id)) {
            throw new CategoryNotFoundException( "Category not found with id: " + id  );
        } 
        repository.deleteById(id);
        return "Category deleted successfully";
    }

}
