package com.pitchIt.messaging.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pitchIt.messaging.model.ChatRoom;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
