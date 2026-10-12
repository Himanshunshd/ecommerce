package com.example.ecommerce.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
    
    private final ProductService service ;   // We created Refernece Variable i.e, "service". Normally -> Studnent(class) s1 = new Student() ;  but here we are not creating object of ProductService class. Spring will create the object and inject that object into Controller class. So, we don't use "new" keyword here.

        public ProductController(ProductService service){  // Spring creates the Service bean and injects it into the Controller's constructor. The constructor stores the reference so your Controller can call Service methods.
            this.service = service ;
        }
 
    @PostMapping("/products")   // API -> Add Product 
    public String addProduct(@Valid @RequestBody Product productVar){   // @RequestBody tells spring to take data from http request and convert into JAVA object. i.e, Product productVar = new Product() ;
        return service.addProduct(productVar) ;       // Spring creates, Service bean and injects  into Controller. We use that Service object to call  addProduct() method and pass the Product data.
    }

    @GetMapping("/products")   // API -> View Product 
    public List<Product> viewProduct(){    
        return service.viewProduct();       
    }

    @GetMapping("/products/{id}")   // API -> View Particular Product and URL---> NO space.
    public Product viewProductById(@PathVariable Long id){    
        return service.viewProductById(id) ;       
    }

    @GetMapping("/products/search/name")   // For search — don't use curly braces(eg.- {name}) if you're using @RequestParam. 
    public List<Product> searchProductByName( @RequestParam String name ){    
        return service.searchProductByName(name) ;       
    }
 
    @GetMapping("/products/search")    
    public List<Product> searchProduct( @RequestParam String name , @RequestParam BigDecimal price ){    
        return service.searchProduct(name , price) ;       
    }

    @PutMapping("/products/{id}")  // API- Upate Product(Full Updation).
    public String updateProduct(@PathVariable Long id, @Valid  @RequestBody Product product){    
        return service.updateProduct(id, product) ;       
    }

    @PatchMapping("/products/{id}")   // API- Partile Update Product.
    public String updatePartileProduct(@PathVariable Long id, @RequestBody Product newProduct){    
        return service.updatePartileProduct(id, newProduct) ;       
    }

    @DeleteMapping("/products/{id}")   // API- Delete Product.
    public String deleteProduct(@PathVariable Long id ){    
        return service.deleteProduct(id ) ;       
    }

}
 
 