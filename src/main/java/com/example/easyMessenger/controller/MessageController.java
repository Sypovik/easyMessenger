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

    // @MessageMapping("/connect")
    // @SendTo("/topic/response")
    // public Map<String, Object> handleConnection(Map<String, Object> clientInfo) {
    // String userId = (String) clientInfo.get("userId");
    // if (!userInfo.containsKey(userId)) {
    // // Новый пользователь
    // userInfo.put(userId, "New User");
    // }
    // System.out.println("userId: " + userId);
    // // Возвращаем информацию о пользователе
    // Map<String, Object> response = new HashMap<>();
    // response.put("userId", userId);
    // response.put("info", userInfo.get(userId));
    // return response;
    // }

    @MessageMapping("/send")
    @SendTo("/topic/response")
    public String handleMessage(String message) {
        messageService.saveMessage(message);
        return "Received your message: \"" + message + "\". Last saved message: \"" + messageService.getMessages()
                + "\".";
    }
}