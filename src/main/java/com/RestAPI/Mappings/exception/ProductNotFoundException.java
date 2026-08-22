package com.RestAPI.Mappings.exception;

import com.RestAPI.Mappings.dto.ErrorResponseDto;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message)
    {
        super(message);
    }

}
