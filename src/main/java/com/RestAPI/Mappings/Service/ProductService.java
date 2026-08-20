package com.RestAPI.Mappings.Service;

import com.RestAPI.Mappings.Model.Product;
import com.RestAPI.Mappings.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

  List<Product> getAllProducts();
  Product getProductById(Integer id);
  Product createProduct(Product product);
  void updateProduct(Product product, Integer id);
  void deleteProduct(Integer id);


}
