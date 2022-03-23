package com.hexa.starter.core.business.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PasswordUtilTest {

    PasswordUtil passwordUtil = new PasswordUtil();

    private static final String PASSWORD = "testPassword";

    @Test
    public void encryptTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
        Assertions.assertNotNull(passwordUtil.encrypt(PASSWORD));
    }

    @Test
    public void compareTest() {
        Assertions.assertEquals(true, passwordUtil.compare(PASSWORD, PASSWORD));
    }

}
