package com.example.cinema.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Set;

//custom validation messeges are located in /resources/messeges.properties

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
    @NotEmpty(message = "{firstName.notempty}")
    private String firstName;
    @Column(name="lastname")
    @NotEmpty(message = "{lastName.notempty}")
    private String lastName;
    @Column(name= "email")
    @Email
    @NotEmpty(message = "{email.notempty}")
    private String email;
    @Column(name="password")
    @NotEmpty(message = "{password.notempty}")
    @Min(value=8, message="{password.size}")
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role roleId;
    public Users() {
    }

}
