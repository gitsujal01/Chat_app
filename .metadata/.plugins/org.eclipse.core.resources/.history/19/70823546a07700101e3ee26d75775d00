package com.substring.chat.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.substring.chat.entities.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String>
{
	Room findByRoomId(String roomId);
}
