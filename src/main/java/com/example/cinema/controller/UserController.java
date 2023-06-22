package com.example.cinema.controller;

import com.example.cinema.entity.Role;
import com.example.cinema.entity.Screening;
import com.example.cinema.entity.Ticket;
import com.example.cinema.entity.Users;
import com.example.cinema.service.RoleService;
import com.example.cinema.service.TicketService;
import com.example.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private TicketService ticketService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService theUserService, TicketService theTicketService, RoleService theRoleService){
        this.userService = theUserService;

        this.ticketService= theTicketService;

        this.roleService =theRoleService;
    }
    @GetMapping("/signin")
    public String signInForm(Model theModel){
        Users user = new Users();
        Iterable<Role> allRoles = roleService.getRoles();


        theModel.addAttribute("roles", allRoles);
        theModel.addAttribute("users", user);
        return "registerForm";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("users") Users users){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        if(users.getRoleId() == null){
            users.setRoleId(roleService.getUserRole(10));
        }

        userService.save(users);
        return "redirect:/users/info";
    }


    @GetMapping("/manage/delete/{userId}")
    @Transactional
    public String deleteUser(@PathVariable int userId){
        Users themp = userService.getUserById(userId);
        userService.deleteUserById(userId);
        return "redirect:/users/info";
    }

    @GetMapping("/manage/info")
    public String listEmployees(Model theModel) {
        Iterable<Users> theUsers = userService.findAll();
        // add to the spring model
        theModel.addAttribute("users", theUsers);
        return "listOfUsers";
    }
    @GetMapping("/myTickets")
    public String listOfMyTickets(Model theModel){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users currentUser = userService.getUsersByEmail(authentication.getName());
        Iterable<Ticket> myTickets = ticketService.findAllTicketsByUser(currentUser);
        theModel.addAttribute("tickets",myTickets);
        return "myTickets";
    }


}
