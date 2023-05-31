package com.example.cinema.dao;

import com.example.cinema.entity.Ticket;
import com.example.cinema.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Iterable<Ticket> findAllByUserId(Users user);
}
