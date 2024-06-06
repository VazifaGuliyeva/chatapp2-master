package com.example.chatapp2.service;

import com.example.chatapp2.model.Message;
import com.example.chatapp2.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class ChatService {

    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message saveUserMessage(String text, String sender) {
        Message message = new Message();
        message.setText(text);
        message.setSender(sender);
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public Message generateBotResponse(String userText) {
        String botResponseText = "I am not sure how to respond to that.";
        if (userText.contains("hello")) {
            botResponseText = "Hello! How can I assist you today?";
        } else if (userText.contains("bye")) {
            botResponseText = "Goodbye! Have a great day!";
        }

        Message botMessage = new Message();
        botMessage.setText(botResponseText);
        botMessage.setSender("Bot");
        botMessage.setTimestamp(LocalDateTime.now());
        return messageRepository.save(botMessage);
    }
}
