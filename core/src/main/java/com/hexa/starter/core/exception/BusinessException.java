package com.hexa.starter.core.exception;

public class BusinessException extends RuntimeException {
    private final ErrorMessage errorMessage;

    public BusinessException(String code, String message) {
        super();
        this.errorMessage = new ErrorMessage(code, message);
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
