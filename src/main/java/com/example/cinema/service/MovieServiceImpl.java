package com.example.cinema.service;

import com.example.cinema.dao.MovieRepository;

public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepo;
    public MovieServiceImpl(MovieRepository themovieRepo) {
        movieRepo = themovieRepo;
    }
}
