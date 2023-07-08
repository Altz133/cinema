package com.example.cinema.controller;

import com.example.cinema.entity.CinemaHall;
import com.example.cinema.entity.Movie;
import com.example.cinema.entity.Screening;
import com.example.cinema.service.MovieService;
import com.example.cinema.service.ScreeningService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MovieController {
    private MovieService movieService;
    private ScreeningService screeningService;
    public MovieController(MovieService theMovieService, ScreeningService theScreeningService) {
        movieService= theMovieService;
        screeningService= theScreeningService;
    }
    @ModelAttribute
    public void init(Model theModel){
        Movie movie = new Movie();
        theModel.addAttribute("movie",movie);
    }

    @GetMapping("/movie")
    public String getMovie(Model theModel){
        Iterable<Movie> movies= this.movieService.findAll();
        theModel.addAttribute("movie", movies);
        return "moviePage";
    }
    @GetMapping("/movie/{movie_id}")
    public String getMovie(@PathVariable(value="movie_id") int movie_id, Model theModel) {
        Optional<Movie> optionalMovie = this.movieService.findById(movie_id);
        Movie myMovie = optionalMovie.orElse(null);
        if(myMovie == null){
            return "error";
        }
        theModel.addAttribute("movie",myMovie);

        return "moviePage";
    }

    @GetMapping("/manage/addMovie")
    public String addMovie(){
        return "addNewMovieForm";

    }
    @PostMapping("/manage/saveMovie")
    public String saveMovie(@ModelAttribute("movie") @Valid Movie movie, BindingResult result){
        if(result.hasErrors())
            return "addNewMovieForm";

        movieService.save(movie);
        return "redirect:/movie";

    }
    @GetMapping("/manage/deleteMovie/{movieId}")
    @Transactional
    public String deleteMovie(@PathVariable int movieId){

        screeningService.deleteScreeningsByMovieId(movieId);
        movieService.deleteMovieById(movieId);
        return "redirect:/movie";
    }


}
