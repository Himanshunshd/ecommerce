package com.example.ecommerce.service;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.ProductNotFoundException;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository; // means - this ProductService has a reference to a ProductRepository object, so I can use that repository inside this class.Ex - private Scanner scanner (You have a Scanner reference called scanner)

    public ProductService(ProductRepository repository) { // constructor , Read as - "When creating a ProductService object, give me a ProductRepository object, and I'll store that object in my repository reference."
        this.repository = repository;
    }

    public String addProduct(Product product) {   // Read as - "This is a method called addProduct that receives a Product object."
        repository.save(product);    // database operation , means - "Service is asking the Repository to save this product."
        return "Product Added Successfully.";
    }

    public List<Product> viewProduct() {    // List<String> list = new ArrayList<>() That's creating an empty List. 
        List<Product> productsList = repository.findAll();   // List<Product> → Data type , products → variable.
        return productsList;
    }

    public Product viewProductById(Long id) {   

        Optional <Product> byId = repository.findById(id) ;  // Ex. -> List<Product> , List containing Product objects and here is Optional.
        return byId.orElseThrow(() ->
        new ProductNotFoundException(  "Product not found with id: " + id ) );   // Why does findById() return Optional but findAll() returns List? in findAll(), list have 0 or 1 or 10 or 1000 Product but in byId(let 5) have 5 is exist or not ?.
    }
    
    public List<Product> searchProductByName(String name) {
        List<Product> products = repository.findByName(name);
        return products;
    }

    public List<Product> searchProduct(String name , BigDecimal price) {    
        List <Product> productsList  = repository.findByNameAndPrice(name , price) ;   
        return productsList  ;    
    }

    public String updateProduct(Long id , Product product) {  // working understand pending ???
        if( repository.existsById(id) ) {   // Don't Need " == true ".
            product.setId(id) ;
            repository.save(product);
            return "Product Updated Successfully."; 
        } else {
            return "Id is invalid. ";
        } 
    }

    public String updatePartileProduct(Long id, Product newProduct) {    //new product data.

        Optional<Product> existing = repository.findById(id);

        if ( existing.isPresent() ) {                         //It checks whether the Optional contains a product.

            Product existingProduct = existing.get();         // .get() retrieves the Product from the Optional.
            existingProduct.setPrice(newProduct.getPrice());    // newProduct.getPrice() means, Gets the new price sent by the user through the API. And Remaining , Updates the price of the product we already found in the database

            repository.save(existingProduct);
            return "Product Updated Successfully.";
        } else {
            return "Id is invalid.";
        }
    }

    public String deleteProduct(Long id ) {
        if( repository.existsById(id) ) { 
            repository.deleteById(id);
            return "Product Deleted Successfully."; 
        } else {
            return "Id is invalid.";
        } 
    }
 
}

 
