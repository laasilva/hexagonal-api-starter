package com.hexa.starter.core.port.command;

import com.hexa.starter.core.model.User;

public interface SaveUserCommand {
    User save(User user);
}
