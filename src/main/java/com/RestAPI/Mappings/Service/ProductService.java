package com.RestAPI.Mappings.Service;

import com.RestAPI.Mappings.Model.Product;
import com.RestAPI.Mappings.dto.ProductRequestDto;
import com.RestAPI.Mappings.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

  List<ProductResponseDto> getAllProducts();
  ProductResponseDto getProductById(Integer id);
  ProductResponseDto createProduct(ProductRequestDto productRequestDto);
  void updateProduct(ProductRequestDto productRequestDto, Integer id);
  void deleteProduct(Integer id);


}
