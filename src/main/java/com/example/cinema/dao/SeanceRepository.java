package com.example.cinema.dao;

import com.example.cinema.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SeanceRepository extends CrudRepository<Seance,Integer> {
    public Seance getSeancesById(int id);
}
