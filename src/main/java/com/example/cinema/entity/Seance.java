package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="seance")
public @Data class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seance_id")
    private int id;

    @OneToMany(mappedBy = "seance_id")
    private List<Ticket> ticketList;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie_id;

    @ManyToOne
    @JoinColumn(name="hall_id")
    private CinemaHall hall_id;


    @Column(name="seance_date")
    private Date date;

    @Column(name="seats_available")
    private int seats_available;

    @Column(name="seance_time")
    private String time;

}
