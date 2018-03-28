package com.isa.ticket.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.isa.ticket.domain.User;

public class GetUsersDTO {
	
	private List<User> users = new ArrayList<User>();
	private String message;
	
	public GetUsersDTO(){
		
	}
	
	public GetUsersDTO(String message, List<User> users){
		this.message = message;
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
