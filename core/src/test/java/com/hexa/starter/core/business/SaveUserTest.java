package com.hexa.starter.core.business;

import com.hexa.starter.core.business.utils.PasswordUtil;
import com.hexa.starter.core.model.User;
import com.hexa.starter.core.port.adapter.PersistUserAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

class SaveUserTest {
    private final PersistUserAdapter persistUserAdapter = Mockito.mock(PersistUserAdapter.class);
    private final PasswordUtil passwordUtil = Mockito.mock(PasswordUtil.class);
    private final SaveUser saveUser = new SaveUser(persistUserAdapter, passwordUtil);

    private static final String USERNAME = "testUsername";
    private static final String PASSWORD = "testPassword";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveTest200() throws NoSuchAlgorithmException, InvalidKeySpecException {
        User user = createMockModel();

        Mockito.when(passwordUtil.encrypt(Mockito.anyString())).thenReturn("");
        Mockito.when(persistUserAdapter.save(Mockito.any(User.class))).thenReturn(user);

        User response = saveUser.save(user);

        Assertions.assertEquals(user, response);
    }

    private User createMockModel() {
        return User.builder()
                .id(1)
                .username(USERNAME)
                .password(PASSWORD)
                .build();
    }
}
