package com.thoughtworks.capacity.gtb.mvc.userRepository;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImp implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public User save(User user){
        user.setId(users.size()+1);
        users.put(user.getName(),user);
        return user;
    }

    @Override
    public User findByName(String username){
        return users.get(username);
    }
}
