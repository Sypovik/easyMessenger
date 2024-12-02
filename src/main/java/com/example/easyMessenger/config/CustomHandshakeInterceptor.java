package com.example.easyMessenger.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;
import java.util.UUID;

public class CustomHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
            WebSocketHandler wsHandler, Map<String, Object> attributes) {

        String userId = cookiSettings(request, response);
        attributes.put("userId", userId);
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
            WebSocketHandler wsHandler, Exception exception) {
        // Ничего не делаем после Handshake
    }

    // cookie settings
    private String cookiSettings(ServerHttpRequest request, ServerHttpResponse response) {
        String cookie = request.getHeaders().getFirst("Cookie");
        String userId;

        if (cookie != null && cookie.contains("userId=")) {
            // Извлекаем userId из куки
            userId = cookie.split("userId=")[1].split(";")[0];
            System.err.println("true userId: " + userId);
        } else {
            // Генерируем новый userId и передаём его клиенту через Set-Cookie
            userId = UUID.randomUUID().toString();
            response.getHeaders().add("Set-Cookie", "userId=" + userId + "; Max-Age=2592000; Path=/");
            System.err.println("false userId: " + userId);
        }
        return userId;
    }
}
