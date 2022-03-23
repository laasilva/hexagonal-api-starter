package com.hexa.starter.core.port.command;

import com.hexa.starter.core.model.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface SaveUserCommand {
    User save(User user) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
