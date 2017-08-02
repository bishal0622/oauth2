package com.oauthdemo.example.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bishal on 7/17/17.
 */
@RestController
@CrossOrigin
public class CheckController {

    @GetMapping("/check/")
    public ResponseEntity<?> check(){
        return new ResponseEntity<String>("This works", HttpStatus.OK);
    }

}
