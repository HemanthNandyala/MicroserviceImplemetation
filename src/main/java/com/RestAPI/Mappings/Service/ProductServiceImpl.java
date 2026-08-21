package com.RestAPI.Mappings.Service;

import com.RestAPI.Mappings.Model.Product;
import com.RestAPI.Mappings.dto.ProductRequestDto;
import com.RestAPI.Mappings.dto.ProductResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    private final RestTemplate restTemplate;

    ProductServiceImpl(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public ProductResponseDto mapToProductResponseDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setCategory(product.getCategory());
        return productResponseDto;
    }

    public Product mapToProduct(ProductRequestDto productRequestDto)
    {
        Product product = new Product();
        product.setTitle(productRequestDto.getTitle());
        product.setCategory(productRequestDto.getCategory());
        product.setPrice(productRequestDto.getPrice());
        product.setDescription(productRequestDto.getDescription());
        return product;
    }

    @Override
    public List<ProductResponseDto> getAllProducts()
    {
        Product[] productArray = restTemplate.getForObject("https://fakestoreapi.com/products" , Product[].class);
        List<ProductResponseDto> responseDtos = new ArrayList<>();
        for(Product product : productArray)
        {
            responseDtos.add(mapToProductResponseDto(product));
        }

        //List<ProductResponseDto> responseDtos = Arrays.Stream(productArray).
                                    //              map(this::mapToProductResponseDto).collect(Collectors.toList());
        return responseDtos;
    }

    @Override
    public ProductResponseDto getProductById(Integer id) {

         String url = "https://fakestoreapi.com/products/" + id;

         Product product = restTemplate.getForObject(url, Product.class);
         return mapToProductResponseDto(product);
           // return restTemplate.getForObject("https://fakestoreapi.com/products/{id}" , Product.class);

    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product productToCreate  = mapToProduct(productRequestDto);
        Product createdProduct = restTemplate.postForObject("https://fakestoreapi.com/products", productToCreate, Product.class);
        return mapToProductResponseDto(createdProduct);
    }

    @Override
    public void updateProduct(ProductRequestDto productRequestDto, Integer id) {
       // restTemplate.put("https://fakestoreapi.com/products/{id}", product ,id);
        Product productToUpdate = mapToProduct(productRequestDto);
        restTemplate.put("https://fakestoreapi.com/products/{id}" , productToUpdate,id);
    }

    @Override
    public void deleteProduct(Integer id) {
        restTemplate.delete("https://fakestoreapi.com/products/{id}" , id);
    }


}
