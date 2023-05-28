package com.example.cinema.dao;

import com.example.cinema.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketsRepository extends CrudRepository<Ticket, Integer> {
}
