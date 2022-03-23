package com.hexa.starter.core.business.utils;

import lombok.NoArgsConstructor;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

@NoArgsConstructor
public class PasswordUtil {

    public String encrypt(String decrypted) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();

        byte[] salt = new byte[16];
        random.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(decrypted.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] hash = factory.generateSecret(spec).getEncoded();

        return new String(hash);
    }

    public Boolean compare(String encryptedPasswordRequest, String encryptedPasswordStored) {
        return encryptedPasswordRequest.equals(encryptedPasswordStored);
    }
}
