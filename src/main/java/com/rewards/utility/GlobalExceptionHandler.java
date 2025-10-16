package com.rewards.utility;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex) {
       Map<String, Object> errorDetails = new HashMap<>();
       errorDetails.put("timestamp", LocalDateTime.now());
       errorDetails.put("message", ex.getMessage());
       errorDetails.put("status", HttpStatus.NOT_FOUND.value());
       return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(Exception.class)
   public ResponseEntity<?> handleGeneralException(Exception ex) {
       Map<String, Object> errorDetails = new HashMap<>();
       errorDetails.put("timestamp", LocalDateTime.now());
       errorDetails.put("message", "Internal Server Error");
       errorDetails.put("details", ex.getMessage());
       errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
       return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
   }
}

