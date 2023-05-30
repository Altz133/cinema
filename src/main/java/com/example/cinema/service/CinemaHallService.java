package com.example.cinema.service;

import com.example.cinema.entity.CinemaHall;

public interface CinemaHallService {
    Iterable <CinemaHall> findAll();
    CinemaHall getCinemaHallByHallId(int id);
}
