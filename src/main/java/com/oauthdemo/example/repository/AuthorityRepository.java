package com.oauthdemo.example.repository;

import com.oauthdemo.example.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Integer>{
}
