package com.isa.ticket.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.isa.ticket.domain.Food;
import com.isa.ticket.domain.Restaurant;

public class GetFoodDTO {
	
	private List<Food> food = new ArrayList<Food> ();
	private String message;

	public GetFoodDTO() {
		
	}
	public GetFoodDTO(String message,List<Food> food){
		this.message = message;
		this.food = food;
	}
	public List<Food> getFood() {
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
