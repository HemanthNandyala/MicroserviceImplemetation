package com.RestAPI.Mappings.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {

    private String title;
    private String description;
    private float price;
    private String category;
}
