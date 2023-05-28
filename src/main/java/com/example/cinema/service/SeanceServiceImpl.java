package com.example.cinema.service;

import com.example.cinema.dao.SeanceRepository;

public class SeanceServiceImpl implements SeanceService{
    private SeanceRepository seanceRepository;
    public SeanceServiceImpl(SeanceRepository theSeanceRepository) {
        this.seanceRepository = theSeanceRepository;
    }
}
