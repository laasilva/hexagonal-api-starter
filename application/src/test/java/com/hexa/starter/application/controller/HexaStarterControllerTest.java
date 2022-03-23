package com.hexa.starter.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexa.starter.application.dto.request.UserRequest;
import com.hexa.starter.application.dto.response.UserResponse;
import com.hexa.starter.application.mapper.UserDtoMapper;
import com.hexa.starter.core.model.User;
import com.hexa.starter.core.port.command.SaveUserCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HexaStarterController.class)
class HexaStarterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDtoMapper mapper;

    @MockBean
    private SaveUserCommand saveUserCommand;
    
    private static final String ENDPOINT = "/starter/user";
    private static final Integer ID = 1;
    private static final String USERNAME = "testUsername";
    private static final String PASSWORD = "testPassword";
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void saveUserTest200() throws Exception {
        Mockito.when(mapper.toModel(Mockito.any())).thenReturn(createMockModel());
        Mockito.when(mapper.toDto(Mockito.any())).thenReturn(createMockResponse());
        Mockito.when(saveUserCommand.save(Mockito.any())).thenReturn(createMockModel());

        ObjectMapper json = new ObjectMapper();

        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json.writeValueAsString(createMockRequest()))
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    private UserRequest createMockRequest() {
        UserRequest request = new UserRequest();
        
        request.setUsername(USERNAME);
        request.setPassword(PASSWORD);
        
        return request;
    }
    
    private User createMockModel() {
        return User.builder().username(USERNAME).password(PASSWORD).build();
    }

    private UserResponse createMockResponse() {
        UserResponse response = new UserResponse();

        response.setId(ID);
        response.setUsername(USERNAME);

        return response;
    }
}
