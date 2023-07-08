package com.example.cinema.controller;

import com.example.cinema.entity.*;
import com.example.cinema.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
public class CinemaController {
    private ScreeningService screeningService;
    private MovieService movieService;
    private CinemaHallService cinemaHallService;
    private TicketService ticketService;
    private UserService userService;

    @Autowired
    public CinemaController(ScreeningService theScreeningService, MovieService theMovieService, CinemaHallService theCinemaHallService, TicketService theTicketService, UserService theUserService) {
        screeningService = theScreeningService;
        movieService= theMovieService;
        cinemaHallService = theCinemaHallService;
        ticketService = theTicketService;
        userService = theUserService;
    }

    @GetMapping("/repertoire")
    public String repertoire(Model theModel){
        Iterable<Screening> theScreening = screeningService.findAllScreenings();
        theModel.addAttribute("Screenings", theScreening);
        return "repertoire";
    }
    @GetMapping("/repertoire/{movie_title}")
    public String repertoire(@PathVariable(value="movie_title")String title, Model theModel){
        Optional<Iterable<Screening>> theScreening = screeningService.findByTitle(title);
        Iterable<Screening> myScreenings = theScreening.orElse(null);
        if(myScreenings == null){
            return "error";
        }
        theModel.addAttribute("Screenings",myScreenings);

        return "repertoire";
    }

    @ModelAttribute
    public void init(Model theModel){
        Screening screening = new Screening();
        Iterable<Movie> theMovies = movieService.findAll();
        Iterable<CinemaHall> theHall = cinemaHallService.findAll();
        theModel.addAttribute("screening",screening);
        theModel.addAttribute("movieOptions", theMovies);
        theModel.addAttribute("cinemaHallOptions",theHall);
    }

    @GetMapping("/manage/addNewScreening")
    public String addNewScreening(){
        return "addScreeningForm";
    }
    @PostMapping("/manage/saveScreening")
    public String saveScreeningForm(@ModelAttribute("Screening") @Valid Screening Screening, BindingResult result){
        if(result.hasErrors())
            return "addScreeningForm";

        int tempSeats= Screening.getHall_id().getSeats();
        int[] seats = IntStream.range(1, tempSeats+1).toArray();
        Screening.setSeats(seats);
        screeningService.save(Screening);
        return "redirect:/repertoire";
    }
    @GetMapping("/screeningId/{screening_id}")
    public String ticketPurchaseForm(@PathVariable(value="screening_id")int screening_id, Model theModel){
        Screening currentScreening =screeningService.getScreeningById(screening_id);
        CinemaHall tempSeats = cinemaHallService.getCinemaHallByHallId(currentScreening.getHall_id().getHallId());
        int[] seats= IntStream.range(1,tempSeats.getSeats()+1).toArray();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users currentUser = userService.getUsersByEmail(authentication.getName());

        Ticket ticket = new Ticket();
        ticket.setUserId(currentUser);
        ticket.setScreening_id(currentScreening);
        theModel.addAttribute("seats",seats);
        theModel.addAttribute("ticket",ticket);
        return "ticketPurchaseForm";
    }
    @PostMapping("/saveTicket")
    public String saveTicketForUser(@ModelAttribute("ticket") Ticket ticket){
        List<Ticket> listOfTickets = new ArrayList<>();
        if(ticket.getSeats().length > 1) {
            for(int i=0;i<ticket.getSeats().length; i++){
                Ticket tick = new Ticket();
                tick.setScreening_id(ticket.getScreening_id());
                tick.setUserId(ticket.getUserId());
                tick.setSeat(ticket.getSeats()[i]);
                tick.setSeats(ticket.getSeats());
                listOfTickets.add(tick);
                ticketService.subtractSeat(ticket.getScreening_id().getId(), ticket.getSeats()[i]);
            }
        }

        ticketService.saveAll(listOfTickets);
        return "redirect:/repertoire";
    }


}
