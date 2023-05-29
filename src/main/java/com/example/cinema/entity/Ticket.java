package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tickets")
public @Data class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Users user_id;

    @ManyToOne
    @JoinColumn(name="seance_id")
    private Seance seance_id;

    @Column(name="seat")
    private int seat;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", seance_id=" + seance_id +
                ", seat=" + seat +
                '}';
    }
}
