package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;

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
    private Time time;

    @Override
    public String toString() {
        return "Seance{" +
                "id=" + id +
                ", ticketList=" + ticketList +
                ", movie_id=" + movie_id +
                ", hall_id=" + hall_id +
                ", date=" + date +
                ", seats_available=" + seats_available +
                ", time='" + time + '\'' +
                '}';
    }
}
