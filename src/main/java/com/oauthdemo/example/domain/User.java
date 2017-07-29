package com.oauthdemo.example.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bishal on 7/17/17.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    Integer id;
    String username;
    String password;
    Boolean enabled;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Authority> authorityList;
    String email;

    public User() {
    }

    public User(String username, String password, Boolean enabled, List<Authority> authorityList, String email) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorityList = authorityList;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", authorityList=" + authorityList +
                ", email='" + email + '\'' +
                '}';
    }
}
