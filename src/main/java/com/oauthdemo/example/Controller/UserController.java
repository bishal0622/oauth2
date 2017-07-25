package com.oauthdemo.example.Controller;

import com.oauthdemo.example.domain.User;
import com.oauthdemo.example.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bishal on 7/17/17.
 */

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<?> display(){
        List<User> userList = userService.getAll();
        return new ResponseEntity<Object>(userList, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<?> insert(@RequestBody User user){
        userService.insert(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody User user){
        userService.update(id,user);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<?> displayByName(@PathVariable String name){
        User user = userService.findByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
