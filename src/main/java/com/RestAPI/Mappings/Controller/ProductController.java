package com.RestAPI.Mappings.Controller;


import com.RestAPI.Mappings.Service.ProductService;
import com.RestAPI.Mappings.dto.ProductRequestDto;
import com.RestAPI.Mappings.dto.ProductResponseDto;
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
    public List<ProductResponseDto> getAllProducts()
    {

        return productService.getAllProducts();
    }

//    @GetMapping("/products/{id}")
//    public Product getProductById(@PathVariable Integer id) {
//        return productService.getProductById(id);
//
//    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Integer id)
    {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK); //We have to give body and status
      //  return ResponseEntity.ok(productService.getProductById(id)); //In Spring
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto)
    {
        return new ResponseEntity<>(productService.createProduct(productRequestDto),HttpStatus.CREATED);
    }
/* Commenting PutMapping- THis returns nothing
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestBody ProductRequestDto productRequestDto , @PathVariable Integer id)
    {
       // return ResponseEntity.status(200).body(productService.updateProduct(product,id));
        productService.updateProduct(productRequestDto,id);
        //return ResponseEntity.ok().build();
        return ResponseEntity.noContent().build();
    } */

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@RequestBody ProductRequestDto productRequestDto , @PathVariable Integer id)
    {
        // return ResponseEntity.status(200).body(productService.updateProduct(product,id));
        ProductResponseDto response = productService.updateProduct(productRequestDto,id);
        //return ResponseEntity.ok().build();
        return ResponseEntity.ok(response);
    }

 /* Commenting controller
    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id)
    {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    } */

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id)
    {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> patchProduct(@RequestBody ProductRequestDto productRequestDto, @PathVariable Integer id)
    {
        ProductResponseDto resposne =  productService.patchUpdateProduct(productRequestDto, id);
        return ResponseEntity.ok(resposne);
    }
}
