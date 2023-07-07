package com.example.cinema.service;

import com.example.cinema.entity.Screening;

import java.util.List;
import java.util.Optional;

public interface ScreeningService {

    Iterable<Screening> findAllScreenings();
    Screening save(Screening theScreening);

    Screening getScreeningById(int id);

    Optional<Iterable<Screening>> findByTitle(String title);

}
