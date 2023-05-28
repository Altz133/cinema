package com.example.cinema.entity;



import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="cinemahall")
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hall_id")
    private int hall_id;

    @OneToMany(mappedBy = "hall_id")
    private List<Seance> seanceList;

    @Column(name="seats")
    private int seats;

    @Column(name="hallname")
    private String hallName;

}
