package com.pitchIt.messaging.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.pitchIt.messaging.model.MessageResponse;

@Component
public class WebSocketEventListener {
    
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void  handleWebSocketConnectListener(SessionConnectedEvent event) {
        System.out.println("New connection received ");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String usermane = (String) headerAccessor.getSessionAttributes().get("username");
        if (usermane != null) {

            MessageResponse messageResponse = new MessageResponse();
            messageResponse.setType("Leave");
            messageResponse.setSender(usermane);

            messagingTemplate.convertAndSend("/topic/public", messageResponse);
        }
    }
}
