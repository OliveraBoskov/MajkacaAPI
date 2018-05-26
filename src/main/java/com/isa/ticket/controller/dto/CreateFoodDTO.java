package com.isa.ticket.controller.dto;

import java.util.ArrayList;

public class CreateFoodDTO {
	
	private String name;
	private float price;
	private String description;
	private String typeF;
	public String getTypeF() {
		return typeF;
	}

	public void setTypeF(String typeF) {
		this.typeF = typeF;
	}

	private ArrayList<Long> sideDishIds;
	
	public ArrayList<Long> getSideDishIds() {
		return sideDishIds;
	}

	public void setSideDishIds(ArrayList<Long> sideDishIds) {
		this.sideDishIds = sideDishIds;
	}

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
