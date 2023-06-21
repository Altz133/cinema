package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="roles")
@ToString
public @Data class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private int id;
    @OneToMany(mappedBy = "roleId")
    @ToString.Exclude
    private List<Users> RoleList;

    @Column(name="role_name")
    private String roleName;

}
