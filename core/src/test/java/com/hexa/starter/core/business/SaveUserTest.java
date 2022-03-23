package com.hexa.starter.core.business;

import com.hexa.starter.core.exception.BusinessException;
import com.hexa.starter.core.model.User;
import com.hexa.starter.core.port.adapter.PersistUserAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;

public class SaveUserTest {
    private final PersistUserAdapter persistUserAdapter = Mockito.mock(PersistUserAdapter.class);
    private final SaveUser saveUser = Mockito.mock(SaveUser.class);

    private static final String USERNAME = "testUsername";
    private static final String PASSWORD = "testPassword";

    @Test
    public void saveTestSuccess() {
        User user = createMockModel();
        Mockito.when(saveUser.save(Mockito.any())).thenReturn(user);

        Assertions.assertEquals(user, saveUser.save(user));
    }

    @Test
    public void saveTestException() {
        Mockito.when(saveUser.save(Mockito.any()))
                .thenThrow(new BusinessException(Mockito.anyString(), Mockito.anyString()));

        Assertions.assertThrows(InvalidUseOfMatchersException.class, () ->
                persistUserAdapter.save(Mockito.any()));
    }

    private User createMockModel() {
        return User.builder().username(USERNAME).password(PASSWORD).build();
    }
}
