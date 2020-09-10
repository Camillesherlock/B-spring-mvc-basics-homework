package com.thoughtworks.capacity.gtb.mvc.userRepository;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    //private final Map<String, User> userList = new HashMap<>();
    static List<User> userList = new ArrayList<User>();
    static int id = 3;
    public void userListInit(){
        userList.add(new User("xiaohong","xiaohong","1@mail.com",1));
        userList.add(new User("xiaolan","xiaolan","2@mail.com",2));
    }

    public void add(User user) {
        user.setId(id);
        id++;
        userList.add(user);
    }

    public Optional<User> findByName(String userName){
        return userList.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst();
    }

}
