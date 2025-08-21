package com.substring.chat.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.substring.chat.entities.Room;


public interface RoomService {
	
        public ResponseEntity<?> createRoom(String roomId);
        public Room joinRoom(String roomId);
       	public Room findByRoomId(String roomId);
}
