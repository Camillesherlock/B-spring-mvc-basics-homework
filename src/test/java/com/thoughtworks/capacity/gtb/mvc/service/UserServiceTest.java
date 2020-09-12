package com.thoughtworks.capacity.gtb.mvc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@MockBean

class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void addUser() throws Exception {
        User user = new User("xiaoming","123456"
                ,"1@234.com",6);
        ObjectMapper objectMapper =new ObjectMapper();
        String user1 = objectMapper.writeValueAsString(user);
//        mockMvc.perform(post("/register").content(user1)
//                .contentType(MediaType.APPLICATION_JSON));


    }


}