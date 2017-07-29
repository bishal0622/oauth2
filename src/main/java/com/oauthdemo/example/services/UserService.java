package com.oauthdemo.example.services;

import com.oauthdemo.example.domain.Authority;
import com.oauthdemo.example.domain.User;
import com.oauthdemo.example.dto.UserDTO;
import com.oauthdemo.example.repository.AuthorityRepository;
import com.oauthdemo.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bishal on 7/17/17.
 */

@Service
public class UserService {

    private UserRepository userRepository;

    private AuthorityRepository authorityRepository;

    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }


    public void insert(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEnabled(false);
        List<Authority> authorityList = new ArrayList<>();
        authorityList.add(authorityRepository.findOne(2));
        user.setAuthorityList(authorityList);
        userRepository.save(user);
    }

    public void update(Integer id, UserDTO userDTO){
        User user1 = userRepository.findOne(id);
        if (user1 != null){
            user1.setUsername(userDTO.getUsername());
            user1.setPassword(userDTO.getPassword());
            userRepository.save(user1);
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

    public void activate(Integer id) {
        User user = userRepository.findOne(id);
        user.setEnabled(true);
        userRepository.save(user);
    }
}
