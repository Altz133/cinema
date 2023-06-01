package com.example.cinema.controller;

import com.example.cinema.entity.*;
import com.example.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.IntStream;

@Controller
public class CinemaController {
    private SeanceService seanceService;
    private MovieService movieService;
    private CinemaHallService cinemaHallService;
    private TicketService ticketService;
    private UserService userService;

    @Autowired
    public CinemaController(SeanceService theSeanceService, MovieService theMovieService, CinemaHallService theCinemaHallService, TicketService theTicketService, UserService theUserService) {
        seanceService = theSeanceService;
        movieService= theMovieService;
        cinemaHallService = theCinemaHallService;
        ticketService = theTicketService;
        userService = theUserService;
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
    @GetMapping("/seanceId/{seance_id}")
    public String ticketPurchaseForm(@PathVariable(value="seance_id")int seance_id, Model theModel){
        Seance currentSeance =seanceService.getSeanceById(seance_id);
        CinemaHall tempSeats = cinemaHallService.getCinemaHallByHallId(currentSeance.getHall_id().getHallId());
        int[] seats= IntStream.range(1,tempSeats.getSeats()+1).toArray();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users currentUser = userService.getUsersByEmail(authentication.getName());

        Ticket ticket = new Ticket();
        ticket.setUserId(currentUser);
        ticket.setSeance_id(currentSeance);
//        ModelAndView mav = new ModelAndView("ticketPurchaseForm");
        theModel.addAttribute("seats",seats);
        theModel.addAttribute("ticket",ticket);
//        mav.addObject("seats",seats);
//        mav.addObject("ticket",ticket);
        return "ticketPurchaseForm";
    }
    @PostMapping("/saveTicket")
    public String saveTicketForUser(@ModelAttribute("ticket") Ticket ticket){
        ticketService.saveTicket(ticket);
        return "redirect:/repertoire";
    }


}
