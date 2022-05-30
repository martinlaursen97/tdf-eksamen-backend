package com.code.tdfeksamenbackend.exception;

public class ApiBadRequestException extends RuntimeException {
    public ApiBadRequestException(String message) {
        super(message);
    }

    public ApiBadRequestException(Throwable cause) {
        super(cause);
    }
}

