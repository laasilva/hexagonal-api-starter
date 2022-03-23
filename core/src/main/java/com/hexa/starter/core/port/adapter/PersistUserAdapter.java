package com.hexa.starter.core.port.adapter;

import com.hexa.starter.core.model.User;

public interface PersistUserAdapter {
    User save(User user);
}
