package com.oauthdemo.example.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CredentialCheck{

    @GetMapping("/status/")
    public ResponseEntity<?> getCredential (){

        Authentication a=SecurityContextHolder.getContext().getAuthentication();
        if (a == null)   return null;
        Object principal=a.getPrincipal();
        String username="";
        if (principal instanceof UserDetails) {
            username=((UserDetails)principal).getUsername();
        }
        return new ResponseEntity<>(username, HttpStatus.OK);
    }
}
