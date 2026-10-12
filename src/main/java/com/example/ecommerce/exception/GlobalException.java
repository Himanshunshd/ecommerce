package com.example.ecommerce.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalException {
    
    @ExceptionHandler( MethodArgumentNotValidException.class )
    public List<FieldError> handleValidation(

        MethodArgumentNotValidException exceptionVari) {
        return exceptionVari.getFieldErrors();       // getFieldErrors() — a method provided by Spring that retrieves validation errors for individual fields || List<FieldError> -> a list of field-error objects.
   
        }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFound( ProductNotFoundException ex ) {

        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("status", "404");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

        }    

} 