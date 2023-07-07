package com.example.cinema.service;

import com.example.cinema.entity.Movie;

import java.util.Optional;

public interface  MovieService {
    Iterable<Movie> findAll();
    Optional<Movie> findById(Integer id);
}
