package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="seance")
@ToString
public @Data class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seance_id")
    private int id;

    @OneToMany(mappedBy = "seance_id")
    @ToString.Exclude
    private List<Ticket> ticketList;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie_id;

    @ManyToOne
    @JoinColumn(name="hall_id")
    private CinemaHall hall_id;


    @Column(name="seance_date")
    private Date date;

    @Column(name="seance_time")
    private Time time;

    @Column(name="seats_available2")
    private int[] seats;


}
