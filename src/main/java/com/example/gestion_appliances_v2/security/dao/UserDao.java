package com.example.gestion_appliances_v2.security.dao;


import com.example.gestion_appliances_v2.security.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository<User, Long> {
    User findByUsername(String username);
    int deleteByUsername(String username);
    User findByEmail(String email);
}
