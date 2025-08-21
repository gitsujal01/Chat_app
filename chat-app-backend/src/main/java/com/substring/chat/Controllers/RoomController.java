package com.substring.chat.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.substring.chat.config.AppConstants;
import com.substring.chat.entities.Message;
import com.substring.chat.entities.Room;
import com.substring.chat.services.RoomService;

@RestController
@CrossOrigin(AppConstants.FRONT_END_BASE_URL)
@RequestMapping("/api/v1/rooms")
public class RoomController {

	@Autowired
	private RoomService rs;
	
	//create room
	@PostMapping
	public ResponseEntity<?> createRoom(@RequestBody String roomId) {
	    roomId = roomId.replace("\"", "").trim();
	    return rs.createRoom(roomId);
	}

	
	//get room
	@GetMapping("/{roomId}")
	public ResponseEntity<?>joinRoom(@PathVariable String roomId)
	{
       Room room = rs.joinRoom(roomId);
       if(room==null)
       {
    	   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found");
       }
       return ResponseEntity.ok(room);
	}
	//get messages
	@GetMapping("/{roomId}/message")
	public ResponseEntity<List<Message>> getMessages(@PathVariable String roomId,
	    @RequestParam(value="page",defaultValue = "0",required = false) int page,
	    @RequestParam(value = "size",defaultValue = "20",required = false) int size)
	{
		Room room = (Room) rs.findByRoomId(roomId);

		if(room == null) {
		    return ResponseEntity.badRequest().build();
		}
	    //pagination
	    List<Message> messages = room.getMessages();
	    int start = Math.max(0, messages.size() - (page + 1) * size);
	    int end = Math.min(messages.size(), start + size);

	    List<Message> paginatedMessages = messages.subList(start, end);

	    return ResponseEntity.ok(paginatedMessages);
	}
}
