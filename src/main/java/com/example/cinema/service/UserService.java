package com.example.cinema.service;

import com.example.cinema.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;

public interface UserService {
    void save(Users theUsers);
    Iterable<Users> findAll();
    Users getUsersByEmail(String email);
    Iterable<String> getEveryRole();
}
