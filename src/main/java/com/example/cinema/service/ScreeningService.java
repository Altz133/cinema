package com.example.cinema.service;

import com.example.cinema.entity.Screening;

import java.util.List;

public interface ScreeningService {

    Iterable<Screening> findAllScreenings();
    Screening save(Screening theScreening);

    Screening getScreeningById(int id);


}
