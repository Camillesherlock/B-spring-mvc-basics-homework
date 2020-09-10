package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameAlreadyExistsException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameOrPassWordInvalidException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnterController {
    private UserService userService;
    public EnterController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("login")
    public ResponseEntity<User> userLogin(@RequestBody @Validated String userName, String passWord) throws UserNameOrPassWordInvalidException {
        User user = new User(userName,passWord,"1@mail.com",5);
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.userLogin(user));
    }
    @PostMapping("/register")
    public ResponseEntity UserRegister(@RequestBody @Validated User user) throws UserNameAlreadyExistsException {
        this.userService.UserRegister(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }




}
