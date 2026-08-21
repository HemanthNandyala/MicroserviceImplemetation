package com.RestAPI.Mappings.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {

    private Integer id;
    private String title;
    private String description;
    private float price;
    private  String category;
}
