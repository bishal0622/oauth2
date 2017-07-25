package com.oauthdemo.example.services;

import com.oauthdemo.example.domain.Authority;
import com.oauthdemo.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component("DomainUserDetailsService")
public class DomainUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
        User user = userService.findByName(name);
        if(user == null){
            throw new UsernameNotFoundException("Username not Found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getEnabled(),true,true,true,getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
            List<GrantedAuthority> authorities = new ArrayList<>();

            for(Authority userAuthority : user.getAuthorityList()){
                authorities.add(new SimpleGrantedAuthority("ROLE_"+userAuthority.getAuthority()));
            }

            return authorities;
    }
}
