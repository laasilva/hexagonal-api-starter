package com.hexa.starter.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ErrorMessage implements Serializable {
    private String status;
    private String message;
}
