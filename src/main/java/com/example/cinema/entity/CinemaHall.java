package com.example.cinema.entity;



import jakarta.persistence.*;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="cinemahall")
@ToString
public @Data class  CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hall_id")
    private int hallId;

    @OneToMany(mappedBy = "hall_id")
    @ToString.Exclude
    private List<Seance> seanceList;

    @Column(name="seats")
    private int seats;

    @Column(name="hallname")
    private String hallName;

}
