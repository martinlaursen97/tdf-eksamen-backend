package com.code.tdfeksamenbackend.exception.handler;

import com.code.tdfeksamenbackend.exception.ApiBadRequestException;
import com.code.tdfeksamenbackend.exception.ApiNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiBadRequestException.class})
    public ResponseEntity<Object> handleApiBadRequestException(ApiBadRequestException e) {
        ApiExceptionContainer apiExceptionContainer = new ApiExceptionContainer(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return ResponseEntity
                .status(apiExceptionContainer.getHttpStatus())
                .body(apiExceptionContainer);
    }

    @ExceptionHandler(value = {ApiNotFoundException.class})
    public ResponseEntity<Object> handleApiNotFoundException(ApiNotFoundException e) {
        ApiExceptionContainer apiExceptionContainer = new ApiExceptionContainer(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return ResponseEntity
                .status(apiExceptionContainer.getHttpStatus())
                .body(apiExceptionContainer);
    }
}