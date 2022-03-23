package com.hexa.starter.core.exception;

public class BusinessException extends RuntimeException {
    private final ErrorMessage errorMessage;

    public BusinessException(String status, String message) {
        super();
        this.errorMessage = new ErrorMessage(status, message);
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
