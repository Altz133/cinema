package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
@ToString
public @Data class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    @OneToMany(mappedBy = "userId")
    @ToString.Exclude
    private List<Ticket> tickets;

    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name= "email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;


    public Users() {
    }



}
