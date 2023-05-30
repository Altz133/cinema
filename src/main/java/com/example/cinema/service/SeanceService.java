package com.example.cinema.service;

import com.example.cinema.entity.Seance;
import com.example.cinema.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface SeanceService {

    Iterable<Seance> findAllSeances();
    Seance save(Seance theSeance);

    Seance getSeanceById(int id);

}
