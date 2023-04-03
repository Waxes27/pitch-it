package com.pitchIt.messaging.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pitchIt.messaging.model.Message;
import com.pitchIt.messaging.model.MessageResponse;

@RestController
public class MessageController {
    
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/javainuse")
    public MessageResponse SendMessage(@Payload MessageResponse message) throws InterruptedException {
        // Thread.sleep(1000);
        // Sanitise
        System.out.println("Sent");
        return message;
    }

    @MessageMapping("/chat.newUser")
    @SendTo("/topic/javainuse")
    public MessageResponse newUser(@Payload MessageResponse message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        System.out.println("JOINED");
        return message;
    }
}
