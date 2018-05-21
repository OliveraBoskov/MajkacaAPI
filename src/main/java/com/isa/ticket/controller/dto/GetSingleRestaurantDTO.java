package com.isa.ticket.controller.dto;

import com.isa.ticket.domain.Restaurant;

public class GetSingleRestaurantDTO {
	
	private Long id;
	private String name;
	private String location;
	private String phoneNumber;
	private String description;
	
	public GetSingleRestaurantDTO() {
		super();
	}
	
	public GetSingleRestaurantDTO(Restaurant restaurant){
		this.id = restaurant.getId();
		this.name = restaurant.getName();
		this.location = restaurant.getLocation();
		this.phoneNumber = restaurant.getPhoneNumber();
		this.description = restaurant.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
