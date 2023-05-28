package com.example.cinema.service;

import com.example.cinema.dao.CinemaHallsRepository;

public class CinemaHallServiceImpl implements CinemaHallService{
    CinemaHallsRepository cinemaHallsRepository;

    public CinemaHallServiceImpl(CinemaHallsRepository cinemaHallsRepository) {
        this.cinemaHallsRepository = cinemaHallsRepository;
    }
}
