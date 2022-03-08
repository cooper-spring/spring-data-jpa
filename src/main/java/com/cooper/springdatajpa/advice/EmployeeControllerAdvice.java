package com.cooper.springdatajpa.advice;

import com.cooper.springdatajpa.advice.response.ErrorMessage;
import com.cooper.springdatajpa.ui.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<ErrorMessage>> handleIllegalArgumentException(IllegalArgumentException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(ApiResponse.create(errorMessage));
    }

}
