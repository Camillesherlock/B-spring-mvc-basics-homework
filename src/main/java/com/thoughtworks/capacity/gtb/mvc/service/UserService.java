package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameAlreadyExistsException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameOrPassWordInvalidException;
import com.thoughtworks.capacity.gtb.mvc.userRepository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
  private UserRepository userRepository;
  public UserService(UserRepository userRepository){
      this.userRepository = userRepository;
  }

  public User userLogin(User user) throws UserNameOrPassWordInvalidException {
      Optional<User> userLogin = userRepository.findByName(user.getUserName());
      if(userLogin.isPresent()){
          if(userLogin.get().getPassWord().equals((user.getPassWord()))){
              return userLogin.get();
          } else{
              throw new UserNameOrPassWordInvalidException();
          }
      } else {
          throw new UserNameOrPassWordInvalidException();
      }
  }

  public void UserRegister(User user) throws UserNameAlreadyExistsException {
    if(userRepository.findByName(user.getUserName()) == null){
        throw new UserNameAlreadyExistsException();
    }
      userRepository.add(user);
  }
}
