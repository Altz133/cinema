package com.example.cinema.service;

import com.example.cinema.dao.CinemaHallsRepository;
import com.example.cinema.entity.CinemaHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaHallServiceImpl implements CinemaHallService{
    CinemaHallsRepository cinemaHallsRepository;

    @Autowired
    public CinemaHallServiceImpl(CinemaHallsRepository cinemaHallsRepository) {
        this.cinemaHallsRepository = cinemaHallsRepository;
    }

    @Override
    public Iterable<CinemaHall> findAll() {
        return cinemaHallsRepository.findAll();
    }
    @Override
    public CinemaHall getCinemaHallByHallId(int id) {
        return cinemaHallsRepository.getCinemaHallByHallId(id);
    }
}
