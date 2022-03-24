package com.hexa.starter.datasource.adapter;

import com.hexa.starter.core.model.User;
import com.hexa.starter.datasource.entity.UserEntity;
import com.hexa.starter.datasource.mapper.UserEntityMapper;
import com.hexa.starter.datasource.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PersistUserTest {

    private final UserRepository repository = Mockito.mock(UserRepository.class);
    private final UserEntityMapper mapper = Mockito.mock(UserEntityMapper.class);

    private final PersistUser persistUser = new PersistUser(repository, mapper);

    private static final Integer ID = 1;
    private static final String USERNAME = "testUsername";
    private static final String PASSWORD = "testPassword";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveTest200() {
        User model = createMockModel();
        UserEntity entity = createMockEntity();

        Mockito.when(repository.save(entity)).thenReturn(entity);
        Mockito.when(mapper.toModel(Mockito.any())).thenReturn(model);

        Assertions.assertEquals(model, persistUser.save(model));
    }

    private User createMockModel() {
        return User.builder().username(USERNAME).password(PASSWORD).build();
    }

    private UserEntity createMockEntity() {
        UserEntity entity = new UserEntity();

        entity.setId(ID);
        entity.setUsername(USERNAME);
        entity.setPassword(PASSWORD);

        return entity;
    }
}
