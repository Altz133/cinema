package com.example.cinema.service;

import com.example.cinema.dao.ScreeningRepository;
import com.example.cinema.entity.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreeningServiceImpl implements ScreeningService{
    private ScreeningRepository ScreeningRepository;
    @Autowired
    public ScreeningServiceImpl(ScreeningRepository theScreeningRepository) {
        this.ScreeningRepository = theScreeningRepository;
    }

    @Override
    public Iterable<Screening> findAllScreenings() {
        return ScreeningRepository.findAll();
    }

    @Override
    public Screening save(Screening theScreening) {
        return ScreeningRepository.save(theScreening);
    }

    @Override
    public Screening getScreeningById(int id) {
        return ScreeningRepository.getScreeningsById(id);
    }


}
