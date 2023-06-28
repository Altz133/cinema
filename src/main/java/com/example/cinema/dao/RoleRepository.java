package com.example.cinema.dao;


import com.example.cinema.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role getRoleById(Integer Id);
    @Query("SELECT id, roleName FROM Role")
    List<Role> getRole();


}
