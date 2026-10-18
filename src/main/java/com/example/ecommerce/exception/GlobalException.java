package com.example.ecommerce.exception;

import java.util.HashMap; 
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice                 //This class contains handlers that can deal with exceptions coming from my controllers.
public class GlobalException {
    
    @ExceptionHandler( MethodArgumentNotValidException.class )      //tells Spring which exception this method handles.
    public Map<String, String> handleValidation(

        MethodArgumentNotValidException exceptionVari) {           //exceptionVari ---> exception object Spring provides when that validation exception occurs
       
            Map<String, String> errorMap = new HashMap<>();
                for (FieldError error : exceptionVari.getFieldErrors() ) {      //For every FieldError in the list of field errors, assign the current error to the variable error and execute the loop body.
                errorMap.put(error.getField(), error.getDefaultMessage() );     //error.getField() retrieves the field name AND error.getDefaultMessage() retrieves the message associated with that error.
            }
            return errorMap;
        }

    @ExceptionHandler(ProductNotFoundException.class)     //Second handler :- product not found
    public ResponseEntity< Map<String, String> > handleProductNotFound( ProductNotFoundException ex ) {

        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("message", ex.getMessage() );     //ex.getMessage() retrieves the message associated with that exception.
        errorMap.put("status", "404");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
    }    

    @ExceptionHandler(CategoryNotFoundException.class)    
    public ResponseEntity< Map<String, String> > handleCategoryNotFound( CategoryNotFoundException ex ) {

        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("message", ex.getMessage() );    
        errorMap.put("status", "404");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);

        } 

} 