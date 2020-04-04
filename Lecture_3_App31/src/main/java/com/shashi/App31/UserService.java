package com.shashi.App31;

import java.util.HashMap;
import java.util.List;

public class UserService {
    HashMap<Integer,User> dataStore;
    public UserService(){
        dataStore = new HashMap<>();
        User user = new User();
        user.setAge(100);
        user.setId(1);
        user.setName("Ramu");
        dataStore.put(1,user);
    }
    public User findAUser(int id){
        return dataStore.get(id);
    }

    public User addAUser(User user){
        dataStore.put(user.getId(),user);
        return user;
    }
    public List<User> findAll(){
        return (List<User>) dataStore.values();
    }

}
