package com.substring.chat.payload;

import java.time.LocalDateTime;

public class MessageRequest {

	private String content;
	private String sender;
    private String roomId;
    private LocalDateTime messageTime;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public LocalDateTime getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(LocalDateTime messageTime) {
		this.messageTime = messageTime;
	}
	public MessageRequest(String content, String sender, String roomId, LocalDateTime messageTime) {
		super();
		this.content = content;
		this.sender = sender;
		this.roomId = roomId;
		this.messageTime = messageTime;
	}
	public MessageRequest() {
		// TODO Auto-generated constructor stub
	}
    
    
    
}
