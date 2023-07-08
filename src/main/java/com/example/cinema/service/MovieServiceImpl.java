package com.example.cinema.service;

import com.example.cinema.dao.MovieRepository;
import com.example.cinema.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepo;
    @Autowired
    public MovieServiceImpl(MovieRepository theMovieRepo) {
        movieRepo = theMovieRepo;
    }

    @Override
    public Iterable<Movie> findAll() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return movieRepo.findById(id);
    }
    @Override
    public void save(Movie movie){
        movieRepo.save(movie);
    }
}
