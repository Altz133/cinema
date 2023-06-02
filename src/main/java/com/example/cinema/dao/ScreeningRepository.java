package com.example.cinema.dao;

import com.example.cinema.entity.Screening;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends CrudRepository<Screening,Integer> {
    public Screening getScreeningsById(int id);
}
