package com.example.chatapp2.controller;

import com.example.chatapp2.model.Message;
import com.example.chatapp2.service.ChatService;
import com.example.chatapp2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
public class ChatController {

    @GetMapping("/chat")
    public String getChatPage(@RequestParam("username") String username, Model model) {
        model.addAttribute("username", username);
        return "chat";
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(Message message) {
        message.setTimestamp(LocalDateTime.now());
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(Message message) {
        message.setTimestamp(LocalDateTime.now());
        message.setText(message.getSender() + " joined the chat");
        return message;
    }
}
