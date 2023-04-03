package com.pitchIt.messaging.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pitchIt.messaging.model.Message;
import com.pitchIt.messaging.model.MessageResponse;

@RestController
public class MessageController {
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public MessageResponse message(Message message) throws InterruptedException {
        Thread.sleep(1000);
        // Sanitise
        return new MessageResponse("Hello" + message.getContent());
    }
}
