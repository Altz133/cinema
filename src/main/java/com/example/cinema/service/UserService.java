package com.example.cinema.service;

import com.example.cinema.entity.Users;

public interface UserService {
    void save(Users theUsers);
    Iterable<Users> findAll();
    Users getUsersByEmail(String email);
}
