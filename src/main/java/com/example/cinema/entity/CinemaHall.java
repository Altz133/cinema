package com.example.cinema.entity;



import jakarta.persistence.*;

import java.util.List;
import lombok.Data;
@Entity
@Table(name="cinemahall")
public @Data class  CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hall_id")
    private int hallId;

    @OneToMany(mappedBy = "hall_id")
    private List<Seance> seanceList;

    @Column(name="seats")
    private int seats;

    @Column(name="hallname")
    private String hallName;

    @Override
    public String toString() {
        return "CinemaHall{" +
                "hallId=" + hallId +
                ", seanceList=" + seanceList +
                ", seats=" + seats +
                ", hallName='" + hallName + '\'' +
                '}';
    }
}
