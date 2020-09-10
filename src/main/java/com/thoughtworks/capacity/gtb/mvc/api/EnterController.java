package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnterController {
    private UserService userService;
    public EnterController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register?username=foo&password=bar&email=e")
    public User userRegister(String userName, String passWord, String email){

    }
    @GetMapping("login?username=foo&password=bar")
    public UserEnter(String userName, String passWord){

    }




}
