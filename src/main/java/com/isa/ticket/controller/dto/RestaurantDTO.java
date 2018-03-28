package com.isa.ticket.controller.dto;

public class RestaurantDTO {
	
	private String name;
	private String location;
	
	public RestaurantDTO(String name, String location) {
		
		this.name = name;
		this.location = location;
	}
	
	public RestaurantDTO() {
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
