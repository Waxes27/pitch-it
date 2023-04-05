package com.pitchIt.messaging.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pitchIt.messaging.model.ChatMessage;
import com.pitchIt.messaging.model.MessageStatus;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    
    long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);

    List<ChatMessage> findByChatId(String chatId);
}
