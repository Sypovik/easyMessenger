package com.example.easyMessenger.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private final List<String> messages = new ArrayList<>();

    public void saveMessage(String message) {
        messages.add(message);
    }

    public String getLastMessage() {
        return messages.isEmpty() ? "No messages yet!" : messages.get(messages.size() - 1);
    }
}