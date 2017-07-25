package com.oauthdemo.example.repository;

import com.oauthdemo.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bishal on 7/17/17.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsername(String name);
}
