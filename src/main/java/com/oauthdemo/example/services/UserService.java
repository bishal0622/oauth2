package com.oauthdemo.example.services;

import com.oauthdemo.example.config.MailSender;
import com.oauthdemo.example.domain.Authority;
import com.oauthdemo.example.domain.User;
import com.oauthdemo.example.dto.UserDTO;
import com.oauthdemo.example.repository.AuthorityRepository;
import com.oauthdemo.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bishal on 7/17/17.
 */

@Service
public class UserService {

    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    private AuthorityRepository authorityRepository;

    private MailSender mailSender;

    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository, MailSender mailSender) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.mailSender = mailSender;
    }

    public void insert(UserDTO userDTO){
        logger.info("UserDTO  :  "+ userDTO.toString());
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEnabled(false);
        List<Authority> authorityList = new ArrayList<>();
        authorityList.add(authorityRepository.findOne(2));
        user.setAuthorityList(authorityList);
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        logger.info("saved user  "+user.toString());
        mailSender.sendMail(user.getEmail(),"Registered to SignUp","Your request for our application is currently waiting for activation. Please wait.. Thankyou");
    }

    public void update(Integer id, UserDTO userDTO){
        logger.info("UserDTO  : "+userDTO.toString());
        User user1 = userRepository.findOne(id);
        if (user1 != null){
            user1.setUsername(userDTO.getUsername());
            user1.setPassword(userDTO.getPassword());
            userRepository.save(user1);
        }
        logger.info("Update :"+user1.toString());
    }

    public void delete(Integer id){
        User user = userRepository.findOne(id);
        if(user != null){
            logger.info("Delete :"+ user.toString());
            userRepository.delete(id);
        }
    }

    public User getUser(Integer id){
        User user = userRepository.findOne(id);
        logger.info("Single User :"+user.toString());
        return user;
    }

    public List<User> getAll(){
        List<User> users = userRepository.findAll();
        logger.info("User List");
        for (User user:
                users) {
            logger.info("User :"+user.toString());
        }
        return users;
    }

    public User findByName(String name){
        User user = userRepository.findByUsername(name);
        logger.info("Find User :"+user.toString());
        return user;
    }

    public void activate(Integer id) {
        User user = userRepository.findOne(id);
        user.setEnabled(true);
        logger.info("Activated User :"+ user.toString());
        userRepository.save(user);
        mailSender.sendMail(user.getEmail(),"Activation Success","Your Account has been activated please try to login in again.");
    }
}
