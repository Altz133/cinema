package com.example.cinema.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;

import java.util.List;

@Entity
@Table(name="screening")
@ToString
public @Data class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="screening_id")
    private int id;

    @OneToMany(mappedBy = "screening_id")
    @ToString.Exclude
    private List<Ticket> ticketList;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie_id;

    @ManyToOne
    @JoinColumn(name="hall_id")
    private CinemaHall hall_id;


    @NotEmpty
    @Column(name="screening_date")
    private Date date;
    @NotEmpty
    @Column(name="screening_time")
    private Time time;

    @Column(name="seats_available2")
    private int[] seats;


}
