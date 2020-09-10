package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnterController {
    private UserService userService;
    public EnterController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<User> userLogin(@RequestBody @Validated User user){
    return ResponseEntity.status(HttpStatus.OK).body(userService.userLogin)
    }
    @PostMapping("/register")
    public ResponseEntity UserRegister(@RequestBody @Validated User user){
        userService.userRegister(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }




}
