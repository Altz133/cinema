package com.example.cinema.service;

import com.example.cinema.entity.Movie;

public interface  MovieService {
    Iterable<Movie> findAll();
}
