package com.RestAPI.Mappings.Service;

import com.RestAPI.Mappings.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {


    private final RestTemplate restTemplate;

    ProductServiceImpl(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts()
    {
        try
        {
            Product[] productArray = restTemplate.getForObject("https://fakestoreapi.com/products" , Product[].class);
            return (productArray != null)  ? Arrays.asList(productArray) : Collections.emptyList();
         }
        catch(RestClientException e)
        {
            return  Collections.emptyList();
        }
    }

    @Override
    public Product getProductById(Integer id) {
        try
        {
            String url = "https://fakestoreapi.com/products/" + id;
            return restTemplate.getForObject(url, Product.class);
           // return restTemplate.getForObject("https://fakestoreapi.com/products/{id}" , Product.class);
        }
        catch(RestClientException e)
        {
            return null;
        }
    }

    @Override
    public Product createProduct(Product product) {
        return restTemplate.postForObject("https://fakestoreapi.com/products", product, Product.class);
    }

    @Override
    public void updateProduct(Product product, Integer id) {
        restTemplate.put("https://fakestoreapi.com/products/{id}", product ,id);
    }

    @Override
    public void deleteProduct(Integer id) {
        restTemplate.delete("https://fakestoreapi.com/products/{id}" , id);
    }


}
