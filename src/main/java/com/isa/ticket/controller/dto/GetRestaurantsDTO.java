package com.isa.ticket.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.isa.ticket.domain.Restaurant;

public class GetRestaurantsDTO {

	private List<Restaurant> restaurants = new ArrayList<Restaurant>();
	private String message;
	
	public GetRestaurantsDTO() {
		
	}
	
	public GetRestaurantsDTO(String message,List<Restaurant> restaurants){
		this.message = message;
		this.restaurants = restaurants;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
