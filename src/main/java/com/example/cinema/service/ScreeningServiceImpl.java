package com.example.cinema.service;

import com.example.cinema.dao.ScreeningRepository;
import com.example.cinema.entity.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService{
    private final ScreeningRepository screeningRepository;
    @Autowired
    public ScreeningServiceImpl(ScreeningRepository theScreeningRepository) {
        this.screeningRepository = theScreeningRepository;
    }

    @Override
    public Iterable<Screening> findAllScreenings() {
        return screeningRepository.findAll();
    }

    @Override
    public Screening save(Screening theScreening) {
        return screeningRepository.save(theScreening);
    }

    @Override
    public Screening getScreeningById(int id) {
        return screeningRepository.getScreeningsById(id);
    }


}
