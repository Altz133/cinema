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
    private ScreeningService ScreeningService;
    private MovieService movieService;
    private CinemaHallService cinemaHallService;
    private TicketService ticketService;
    private UserService userService;

    @Autowired
    public CinemaController(ScreeningService theScreeningService, MovieService theMovieService, CinemaHallService theCinemaHallService, TicketService theTicketService, UserService theUserService) {
        ScreeningService = theScreeningService;
        movieService= theMovieService;
        cinemaHallService = theCinemaHallService;
        ticketService = theTicketService;
        userService = theUserService;
    }

    @GetMapping("/repertoire")
    public String repertoire(Model theModel){
        Iterable<Screening> theScreening = ScreeningService.findAllScreenings();
        theModel.addAttribute("Screenings", theScreening);
        return "repertoire";
    }

    @GetMapping("/addNewScreening")
    public String addNewScreening( Model theModel){
        Screening screening = new Screening();
        Iterable<Movie> theMovies = movieService.findAll();
        Iterable<CinemaHall> theHall = cinemaHallService.findAll();
        theModel.addAttribute("screening",screening);
        theModel.addAttribute("movieOptions", theMovies);
        theModel.addAttribute("cinemaHallOptions",theHall);
        return "addScreeningForm";
    }
    @PostMapping("/saveScreening")
    public String saveScreeningForm(@ModelAttribute("Screening") Screening Screening){
        int tempSeats= Screening.getHall_id().getSeats();
        int[] seats = IntStream.range(1, tempSeats+1).toArray();
        Screening.setSeats(seats);
        ScreeningService.save(Screening);
        return "redirect:/repertoire";
    }
    @GetMapping("/screeningId/{screening_id}")
    public String ticketPurchaseForm(@PathVariable(value="screening_id")int screening_id, Model theModel){
        Screening currentScreening =ScreeningService.getScreeningById(screening_id);
        CinemaHall tempSeats = cinemaHallService.getCinemaHallByHallId(currentScreening.getHall_id().getHallId());
        int[] seats= IntStream.range(1,tempSeats.getSeats()+1).toArray();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users currentUser = userService.getUsersByEmail(authentication.getName());

        Ticket ticket = new Ticket();
        ticket.setUserId(currentUser);
        ticket.setScreening_id(currentScreening);
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
