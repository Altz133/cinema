package com.example.cinema.service;

import com.example.cinema.dao.UserRepository;
import com.example.cinema.entity.Users;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @PersistenceContext
    private EntityManager em;

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

    @Override
    public Users getUsersByEmail(String email) {
        return userRepository.getUsersByEmail(email);
    }


    public void deleteUserById(int id) { userRepository.deleteUsersById(id); };

    public Users getUserById(Integer id){
        return userRepository.getUserById(id);
    }


}
