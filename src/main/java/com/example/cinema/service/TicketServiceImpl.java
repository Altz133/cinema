package com.example.cinema.service;

import com.example.cinema.dao.TicketsRepository;

public class TicketServiceImpl implements TicketService {

    private TicketsRepository ticketsRepository;

    public TicketServiceImpl(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }
}
