package com.RestAPI.Mappings.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private int id;
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;
}
