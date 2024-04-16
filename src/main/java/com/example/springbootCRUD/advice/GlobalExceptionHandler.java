package com.example.springbootCRUD.advice;

import com.example.springbootCRUD.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> handleUserNotFoundException(UserNotFoundException userNotFoundException){
      Map<String,String> map=new HashMap();
      map.put("errorMessage", userNotFoundException.getMessage());
      return map;
    }
}
