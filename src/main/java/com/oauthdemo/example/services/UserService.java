package com.oauthdemo.example.services;

import com.oauthdemo.example.domain.User;
import com.oauthdemo.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bishal on 7/17/17.
 */

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void insert(User user){
        userRepository.save(user);
    }

    public void update(Integer id, User user){
        User user1 = userRepository.findOne(id);
        if (user1 != null){
            user.setUsername(user.getUsername());
            userRepository.save(user);
        }
    }

    public void delete(Integer id){
        User user = userRepository.findOne(id);
        if(user != null){
            userRepository.delete(id);
        }
    }

    public User getUser(Integer id){
        User user = userRepository.findOne(id);
        return user;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User findByName(String name){
        return userRepository.findByUsername(name);
    }
}
