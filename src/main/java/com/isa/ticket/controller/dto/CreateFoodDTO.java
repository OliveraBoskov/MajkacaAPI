package com.isa.ticket.controller.dto;

public class CreateFoodDTO {
	
	private String name;
	private float price;
	private String description;
	
	public CreateFoodDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
