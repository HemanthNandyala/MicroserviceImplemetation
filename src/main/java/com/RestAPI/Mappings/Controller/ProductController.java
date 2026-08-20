package com.RestAPI.Mappings.Controller;

import com.RestAPI.Mappings.Model.Product;
import com.RestAPI.Mappings.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {


    private final ProductService productService;

    ProductController(ProductService productService)
    {
        this.productService= productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

//    @GetMapping("/products/{id}")
//    public Product getProductById(@PathVariable Integer id) {
//        return productService.getProductById(id);
//
//    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id)
    {
        return new ResponseEntity<> (productService.getProductById(id), HttpStatus.ACCEPTED); //We have to give body and status
      //  return ResponseEntity.ok(productService.getProductById(id)); //In Spring
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {
        return new ResponseEntity<>(productService.createProduct(product),HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product , @PathVariable Integer id)
    {
       // return ResponseEntity.status(200).body(productService.updateProduct(product,id));
        productService.updateProduct(product,id);
        //return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id)
    {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
