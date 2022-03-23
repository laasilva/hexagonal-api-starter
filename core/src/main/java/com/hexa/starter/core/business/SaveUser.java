package com.hexa.starter.core.business;

import com.hexa.starter.core.business.utils.PasswordUtil;
import com.hexa.starter.core.exception.BusinessException;
import com.hexa.starter.core.model.User;
import com.hexa.starter.core.port.adapter.PersistUserAdapter;
import com.hexa.starter.core.port.command.SaveUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class SaveUser implements SaveUserCommand {

    private final PersistUserAdapter persist;
    private final PasswordUtil passwordUtil = new PasswordUtil();

    @Override
    public User save(User user) {
        user.setPassword(passwordUtil.encrypt(user.getPassword()));
        return persist.save(user);
    }
}
