package com.hexa.starter.core.business.utils;

import com.hexa.starter.core.exception.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BusinessExceptionTest {

    private final BusinessException businessException = new BusinessException("", "");

    @Test
    void getErrorMessage() {
        Assertions.assertNotNull(businessException.getErrorMessage());
    }
}
