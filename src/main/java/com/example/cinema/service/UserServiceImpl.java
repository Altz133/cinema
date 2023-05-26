package com.example.cinema.service;

import com.example.cinema.dao.UserRepository;
import com.example.cinema.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public void save(Users theUsers) {
        userRepository.save(theUsers);
    }

    @Override
    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }

}
