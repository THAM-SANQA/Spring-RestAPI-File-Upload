package com.enviro.assessment.grad001.thamsanqandaba.exception;

/**
 * Custom API Exception
 * Author: thamsanqa 2024
 **/

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message); // Call superclass constructor with message
    }
}