package com.isa.ticket.controller.dto;

import com.isa.ticket.domain.User;

public class ResponseDTO {

	private String message;
	private User user;
	
	public ResponseDTO() {
		
	}
	
	public ResponseDTO(String message) {
		this.message = message;
	}
	
	public ResponseDTO(String message,User user){
		this.message = message;
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
