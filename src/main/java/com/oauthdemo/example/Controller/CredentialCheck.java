package com.oauthdemo.example.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CredentialCheck{

    private static final Logger logger =
            LoggerFactory.getLogger(CredentialCheck.class);

    @GetMapping("/status/")
    public ResponseEntity<?> getCredential (){

        Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal == null){
            return null;
        }
        return new ResponseEntity<>(principal, HttpStatus.OK);
    }
}
