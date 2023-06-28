package com.example.cinema.dao;

import com.example.cinema.entity.Ticket;
import com.example.cinema.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Iterable<Ticket> findAllByUserId(Users user);


    @Query("SELECT seat FROM Ticket WHERE screening_id = :screeningId")
    Iterable<int[]> getAllTakenSeats(int screeningId);

    @Query(value = "SELECT subtract_seat(:sid,:seat) ", nativeQuery = true)
    void subtractSeat(@Param("sid")int screeningId, @Param("seat")int seat);

}
