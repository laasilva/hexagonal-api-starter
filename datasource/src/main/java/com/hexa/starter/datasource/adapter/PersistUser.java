package com.hexa.starter.datasource.adapter;

import com.hexa.starter.core.model.User;
import com.hexa.starter.core.port.adapter.PersistUserAdapter;
import com.hexa.starter.datasource.mapper.UserEntityMapper;
import com.hexa.starter.datasource.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PersistUser implements PersistUserAdapter {

    private final UserRepository repository;
    private final UserEntityMapper mapper;

    @Override
    public User save(User user) {
        final var entity = repository.save(mapper.toEntity(user));
        return mapper.toModel(entity);
    }
}
