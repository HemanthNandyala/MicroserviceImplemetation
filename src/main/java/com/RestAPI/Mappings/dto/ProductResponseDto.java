package com.RestAPI.Mappings.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {

    private Integer id;
    private String title;
    private String description;
    private Double price;
    private  String category;
}
