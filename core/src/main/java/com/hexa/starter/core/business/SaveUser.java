package com.hexa.starter.core.business;

import com.hexa.starter.core.business.utils.PasswordUtil;
import com.hexa.starter.core.exception.BusinessException;
import com.hexa.starter.core.model.User;
import com.hexa.starter.core.port.adapter.PersistUserAdapter;
import com.hexa.starter.core.port.command.SaveUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RequiredArgsConstructor
@Slf4j
public class SaveUser implements SaveUserCommand {

    private final PersistUserAdapter persist;
    private final PasswordUtil passwordUtil = new PasswordUtil();

    @Override
    public User save(User user) {
        try {
            user.setPassword(passwordUtil.encrypt(user.getPassword()));
            return persist.save(user);
        } catch (BusinessException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            log.error("Could not encrypt password, check stacktrace.");
            e.printStackTrace();
        }
        return null;
    }
}
