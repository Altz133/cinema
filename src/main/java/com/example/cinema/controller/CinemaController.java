package com.example.cinema.controller;

import com.example.cinema.entity.CinemaHall;
import com.example.cinema.entity.Movie;
import com.example.cinema.entity.Seance;
import com.example.cinema.entity.Ticket;
import com.example.cinema.service.CinemaHallService;
import com.example.cinema.service.MovieService;
import com.example.cinema.service.SeanceService;
import com.example.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.stream.IntStream;

@Controller
public class CinemaController {
    private SeanceService seanceService;
    private MovieService movieService;
    private CinemaHallService cinemaHallService;
    private TicketService ticketService;

    @Autowired
    public CinemaController(SeanceService theSeanceService, MovieService theMovieService, CinemaHallService theCinemaHallService, TicketService theTicketService) {
        seanceService = theSeanceService;
        movieService= theMovieService;
        cinemaHallService = theCinemaHallService;
        ticketService = theTicketService;
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
        int tempSeats= seance.getHall_id().getSeats();
        int[] seats = IntStream.range(1, tempSeats+1).toArray();
        seance.setSeats(seats);
        seanceService.save(seance);
        return "redirect:/repertoire";
    }
    @GetMapping("/seanceId/{seance_id}/name/{username}")
    public String ticketPurchaseForm(@PathVariable(value="seance_id")int seance_id, @PathVariable(value="username") String username, Model theModel){
        Seance tempSeance =seanceService.getSeanceById(seance_id);
        int seanceHallId = tempSeance.getHall_id().getHallId();
        CinemaHall tempSeats = cinemaHallService.getCinemaHallByHallId(seanceHallId);
        System.out.println(tempSeats.getSeats());
        int[] seats= IntStream.range(1,tempSeats.getSeats()+1).toArray();

        Ticket ticket = new Ticket();
        theModel.addAttribute("seats",seats);
        theModel.addAttribute("ticket",ticket);
        return "ticketPurchaseForm";
    }
    @PostMapping("/saveTicket")
    public String saveTicketForUser(@ModelAttribute("ticket") Ticket ticket){
//        ticket.save();
        return "redirect:/repertoire";
    }


}
