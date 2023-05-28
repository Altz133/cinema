package com.example.cinema.dao;

import com.example.cinema.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer>{

}
