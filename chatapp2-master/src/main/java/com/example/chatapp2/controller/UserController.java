package com.example.chatapp2.controller;

import com.example.chatapp2.model.User;
import com.example.chatapp2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String surname) {
        return "redirect:/chat?username=" + name + " " + surname;
    }

    @GetMapping("/another-method")
    public String anotherMethod() {
        return "anotherMethod";
    }
}
