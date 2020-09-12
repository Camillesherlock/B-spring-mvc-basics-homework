package com.thoughtworks.capacity.gtb.mvc.userRepository;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
  User save(User user);

  User findByName(String username);

}
