package com.example.cinema.controller;

import com.example.cinema.entity.CinemaHall;
import com.example.cinema.entity.Movie;
import com.example.cinema.entity.Seance;
import com.example.cinema.service.CinemaHallService;
import com.example.cinema.service.MovieService;
import com.example.cinema.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CinemaController {
    private SeanceService seanceService;
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    @Autowired
    public CinemaController(SeanceService theSeanceService, MovieService theMovieService, CinemaHallService theCinemaHallService) {
        seanceService = theSeanceService;
        movieService= theMovieService;
        cinemaHallService = theCinemaHallService;
    }

    @GetMapping("/repertoire")
    public String repertoire(Model theModel){
        Iterable<Seance> theSeance = seanceService.findAllSeances();
        theModel.addAttribute("seances", theSeance);
        return "repertoire";
    }

    @GetMapping("/addNewSeance")
    public String addNewSeance( Model theModel){
        Seance seance = new Seance();
        Iterable<Movie> theMovies = movieService.findAll();
        Iterable<CinemaHall> theHall = cinemaHallService.findAll();
        theModel.addAttribute("seance",seance);
        theModel.addAttribute("movieOptions", theMovies);
        theModel.addAttribute("cinemaHallOptions",theHall);
        return "addSeanceForm";
    }
    @PostMapping("/saveSeance")
    public String saveSeanceForm(@ModelAttribute("seance") Seance seance){

        seance.setSeats_available(seance.getHall_id().getSeats());
        seanceService.save(seance);
        return "redirect:/repertoire";
    }

}
