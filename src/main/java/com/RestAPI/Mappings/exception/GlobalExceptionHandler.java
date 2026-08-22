package com.RestAPI.Mappings.exception;


import com.RestAPI.Mappings.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleProductNotFoundException(ProductNotFoundException exception, HttpServletRequest requestURL)
  {
      ErrorResponseDto error = new ErrorResponseDto(
              LocalDateTime.now(),
              404,  //Idi body lo vache resposne
              "NotFound",
              exception.getMessage(),
              requestURL.getRequestURI());

     // return ResponseEntity.ok(error) ;   //Http Status successful anukuntadi -> 200 with error body istadi
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); //ila istey status anedi 404 not found istadi
  }
}
