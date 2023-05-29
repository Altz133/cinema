package com.example.cinema.controller;

import com.example.cinema.entity.Seance;
import com.example.cinema.entity.Users;
import com.example.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService theUserService){
        this.userService = theUserService;
    }


    @GetMapping("/signin")
    public String signInForm(Model theModel){
        Users user = new Users();
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
        users.setRole("ROLE_USER");
        userService.save(users);
        return "redirect:/users/info";
    }



    @GetMapping("/info")
    public String listEmployees(Model theModel) {
        Iterable<Users> theUsers = userService.findAll();
        // add to the spring model
        theModel.addAttribute("users", theUsers);


        return "listOfUsers";
    }


}
