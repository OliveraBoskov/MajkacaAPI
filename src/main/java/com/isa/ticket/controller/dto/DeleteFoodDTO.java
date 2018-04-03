package com.isa.ticket.controller.dto;

public class DeleteFoodDTO {
	private String name;
	private float price;
	private String type;
	private String description;
	
	public DeleteFoodDTO() {
		super();
		
	}
	
	public DeleteFoodDTO(String name, float price, String type, String description) {
		super();
		this.name= name;
		this.price= price;
		this.type= type;
		this.description= description;
		
		
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
