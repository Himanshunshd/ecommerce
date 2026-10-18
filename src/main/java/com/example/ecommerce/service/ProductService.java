package com.example.ecommerce.service;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.exception.ProductNotFoundException;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import com.example.ecommerce.dto.ProductPriceUpdate;
import com.example.ecommerce.dto.ProductRequest ;
import com.example.ecommerce.dto.ProductResponse; 

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList ;

@Service
public class ProductService {

    private final ProductRepository repository;               // means - this ProductService has a reference to a ProductRepository object, so I can use that repository inside this class.Ex - private Scanner scanner (You have a Scanner reference called scanner)
 
    private final CategoryRepository categoryRepository;                
  
    public ProductService ( ProductRepository repository, CategoryRepository categoryRepository ) {     // We didn't create ProductRepository a second time. We injected two different repository dependencies into the same service.
        this.repository = repository;
        this.categoryRepository = categoryRepository   ; 
    } 

    public String addProduct(ProductRequest productVar) {     //API - Add Product Handle and Read as - "This is a method called addProduct that receives a Product object."
       
        Product product = new Product();

            product.setName(productVar.getName());
            product.setPrice(productVar.getPrice());
            product.setQuantity(productVar.getQuantity());
            product.setDescription(productVar.getDescription());

            Long id =  productVar.getCategoryId() ;   // Get the category ID.
            Optional <Category> categoryOptional = categoryRepository.findById(id) ;  // Find the category by ID using the CategoryRepository. It returns an Optional<Category> object, which may or may not contain a Category.

            if( categoryOptional.isPresent() ) {  
                 
                Category existingCategory = categoryOptional.get();    //Means - Get the actual Category object from the Optional and store it in existingCategory
                product.setCategory(existingCategory);              // Set the existing category to the product before saving it to the database.
                repository.save(product);
                return "Product Added Successfully.";
            } else { 
                return "Invalid Category Id." ; 
            }
 
    }

    public List<ProductResponse> viewProduct() {    // List<String> list = new ArrayList<>() That's creating an empty List. 
         
        List<Product> productslist = repository.findAll();    //This retrieves the products from the database. Then we need to create a ProductResponse for each product and copy its fields.
        List<ProductResponse> productResponseList = new ArrayList<>();  // Create an empty list to hold the ProductResponse objects.

            for (Product travel : productslist) {

                ProductResponse productResponse = new ProductResponse();

                productResponse.setId ( travel.getId() );
                productResponse.setName ( travel.getName() );
                productResponse.setPrice ( travel.getPrice() );
                productResponse.setQuantity ( travel.getQuantity() );
                productResponse.setDescription( travel.getDescription() );

                if (travel.getCategory() != null) {     
                    productResponse.setCategoryId(travel.getCategory().getId());       //Product object already contains a reference to its Category object because we defined a JPA relationship.
                    productResponse.setCategoryName(travel.getCategory().getName());   //travel.getCategory() — gets the associated Category object.
                }
                productResponseList.add(productResponse);
            }
                return productResponseList;  // Return the list of ProductResponse objects to the controller, which will send it back to the client as a JSON response.;
    }   

    public Product viewProductById(Long id) {   

        Optional <Product> byId = repository.findById(id) ;  // Ex. -> List<Product> , List containing Product objects and here is Optional.
            return byId.orElseThrow ( () ->  new ProductNotFoundException(  "Product not found with id: " + id ) );   // Why does findById() return Optional but findAll() returns List? in findAll(), list have 0 or 1 or 10 or 1000 Product but in byId(let 5) have 5 is exist or not ?.
    }
    
    public List<Product> searchProductByName(String name) {
        List<Product> products = repository.findByName(name);
        return products;
    }

    public List<Product> searchProduct(String name , BigDecimal price) {    
        List <Product> productsList  = repository.findByNameAndPrice(name , price) ;   
        return productsList  ;    
    }

    public String updateProduct(Long id , Product productVar) {      // working understand pending ???

        if(repository.existsById(id) ){

            Long ids =  productVar.getCategory().getId() ;    //get category's id.
            Optional <Category> categoryOptional = categoryRepository.findById(ids) ;   

            if( categoryOptional.isPresent() ) {  
                 
                Category existingCategory = categoryOptional.get();     
                productVar.setCategory(existingCategory);
                productVar.setId(id) ;
                repository.save(productVar);
                return "Product Updated Successfully."; 
            } else {
                return "Category ID Is Invalid.";
            }
        } else {
            return "Enter Valid Product's ID.";

         }
         
    }
 
    public String updatePartileProduct(Long id, ProductPriceUpdate newProduct) {    //new product data.

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

    public String deleteProduct(Long id) {

        if (!repository.existsById(id)) {
            throw new ProductNotFoundException( "Product not found with id: " + id  );
        } 
        repository.deleteById(id);
        return "Product deleted successfully";
    }
 
}

