package com.example.demo.exception;

public class GlobalExceptionHandler {
    public String handleException(Exception e) {
        return e.getMessage();
    }
}