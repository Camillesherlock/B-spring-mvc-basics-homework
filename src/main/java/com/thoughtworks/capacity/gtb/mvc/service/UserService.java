package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.dto.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.exception.LoginErrorException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserIsExistException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.userRepository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
    this.userRepository=userRepository;
    }

    public void userRegister(UserRequest userquest){
        User user = userRepository.findByName(userquest.getUsername());
        if(user != null){
            throw new UserIsExistException("用户已存在");
        }
        User newUser = User.builder().name(userquest.getUsername())
                .email(userquest.getEmail())
                .password(userquest.getPassword())
                .build();
        userRepository.save(newUser);
    }

    public User userLogin(String username, String password){
        User user = userRepository.findByName(username);
        if(user == null)
            throw new UserNotFoundException("用户不存在");
        if(user.getPassword() == password){
            return user;
        }
        throw new LoginErrorException("用户名或密码错误");
    }
}
