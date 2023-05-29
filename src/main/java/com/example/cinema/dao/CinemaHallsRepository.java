package com.example.cinema.dao;

import com.example.cinema.entity.CinemaHall;
import org.springframework.data.repository.CrudRepository;

public interface CinemaHallsRepository extends CrudRepository<CinemaHall,Integer> {
    public int getCinemaHallByHallId(int id);
}
