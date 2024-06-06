package com.example.chatapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    @PostMapping("/register")
    public ModelAndView register(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        String username = name + " " + surname;
        ModelAndView mav = new ModelAndView("redirect:/chat");
        mav.addObject("username", username);
        return mav;
    }
}
