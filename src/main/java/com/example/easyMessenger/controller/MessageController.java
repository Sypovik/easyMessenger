package com.example.easyMessenger.controller;

import com.example.easyMessenger.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/send")
    @SendTo("/topic/response")
    public String handleMessage(String message) {
        messageService.saveMessage(message);
        return "Received your message: \"" + message + "\". Last saved message: \"" + messageService.getLastMessage()
                + "\".";
    }
}