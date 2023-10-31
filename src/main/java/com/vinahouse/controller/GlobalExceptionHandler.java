package com.vinahouse.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("da co loi");
        List<FieldError> list = ex.getBindingResult().getFieldErrors();
        System.out.println("so loi : " + list.size());
        list.forEach(e -> System.out.println(e.getDefaultMessage()));
        System.out.println(status.value());
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
}
