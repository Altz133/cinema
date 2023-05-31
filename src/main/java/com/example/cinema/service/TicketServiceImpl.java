package com.example.cinema.service;

import com.example.cinema.dao.TicketRepository;
import com.example.cinema.entity.Ticket;
import com.example.cinema.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService{

    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository theTicketRepository) {
        ticketRepository = theTicketRepository;
    }

    public void saveTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public Iterable<Ticket> findAllTicketsByUser(Users user) {return ticketRepository.findAllByUserId(user);}



}
