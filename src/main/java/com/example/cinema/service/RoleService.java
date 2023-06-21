package com.example.cinema.service;

import com.example.cinema.entity.Role;

import java.util.List;

public interface RoleService {
    Role getUserRole(Integer Id);


    Iterable<Role> getRoles();
}
