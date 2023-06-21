package com.example.cinema.dao;

import com.example.cinema.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,Integer> {
    Users getUsersByEmail(String email);
    Users getUserById(Integer id);



    void deleteUsersById(int id);

}
