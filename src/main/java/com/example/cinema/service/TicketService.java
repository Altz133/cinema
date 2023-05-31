package com.example.cinema.service;

import com.example.cinema.entity.Ticket;
import com.example.cinema.entity.Users;


public interface TicketService {
    void saveTicket(Ticket ticket);
    Iterable<Ticket> findAllTicketsByUser(Users user);

}
