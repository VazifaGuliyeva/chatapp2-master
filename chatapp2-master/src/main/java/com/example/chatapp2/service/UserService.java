package com.example.chatapp2.service;

import com.example.chatapp2.model.User;
import com.example.chatapp2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User registerUser(String name, String surname) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
