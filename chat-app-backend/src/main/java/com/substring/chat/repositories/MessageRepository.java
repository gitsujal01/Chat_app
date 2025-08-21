package com.substring.chat.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.substring.chat.entities.Message;

public interface MessageRepository extends MongoRepository<Message,String>{

}
