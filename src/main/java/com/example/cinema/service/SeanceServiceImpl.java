package com.example.cinema.service;

import com.example.cinema.dao.SeanceRepository;
import com.example.cinema.entity.Seance;
import com.example.cinema.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeanceServiceImpl implements SeanceService{
    private SeanceRepository seanceRepository;
    @Autowired
    public SeanceServiceImpl(SeanceRepository theSeanceRepository) {
        this.seanceRepository = theSeanceRepository;
    }

    @Override
    public Iterable<Seance> findAllSeances() {
        return seanceRepository.findAll();
    }

    @Override
    public Seance save(Seance theSeance) {
        return seanceRepository.save(theSeance);
    }
}
