package com.example.cinema.service;

import com.example.cinema.dao.RoleRepository;
import com.example.cinema.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getUserRole(Integer Id){
        return roleRepository.getRoleById(Id);
    }

    @Override
    public Iterable<Role> getRoles() { return roleRepository.findAll();}
}
