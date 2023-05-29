package com.example.cinema.service;

import com.example.cinema.dao.MovieRepository;
import com.example.cinema.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepo;
    @Autowired
    public MovieServiceImpl(MovieRepository themovieRepo) {
        movieRepo = themovieRepo;
    }

    @Override
    public Iterable<Movie> findAll() {
        return movieRepo.findAll();
    }
}
