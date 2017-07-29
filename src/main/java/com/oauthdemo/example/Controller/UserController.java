package com.oauthdemo.example.Controller;

import com.oauthdemo.example.domain.User;
import com.oauthdemo.example.dto.UserDTO;
import com.oauthdemo.example.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

/**
 * Created by bishal on 7/17/17.
 */

@RestController
@CrossOrigin
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
    public ResponseEntity<?> insert(@RequestBody UserDTO userDTO){
        userService.insert(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        userService.update(id,userDTO);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/user/activate/{id}")
    public ResponseEntity<?> activate(@PathVariable Integer id){
        userService.activate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<?> displayByName(@PathVariable String name){
        User user = userService.findByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> displayById(@PathVariable Integer id){
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
