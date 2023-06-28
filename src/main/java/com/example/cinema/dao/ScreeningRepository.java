package com.example.cinema.dao;

import com.example.cinema.entity.Screening;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreeningRepository extends CrudRepository<Screening,Integer> {
    Screening getScreeningsById(int id);


}
