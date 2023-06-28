package com.example.cinema.service;

import com.example.cinema.entity.Ticket;
import com.example.cinema.entity.Users;

import java.util.List;


public interface TicketService {
    void saveTicket(Ticket ticket);
    Iterable<Ticket> findAllTicketsByUser(Users user);

    Iterable<int[]> getAllTakenSeats (int id);
    void saveAll(List<Ticket> ticketList);
    void subtractSeat(int screening_id, int seat );
}
