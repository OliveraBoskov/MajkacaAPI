package com.isa.ticket.controller.dto;

import com.isa.ticket.domain.Food;

public class GetSingleFoodDTO {
	
	private Long id;
	private String name;
	private float price;
	private String typeF;
	private String description;
	
	
	public GetSingleFoodDTO() {
		super();
	}
	
	
	public GetSingleFoodDTO(Food food) {
		super();
		this.id = food.getId();
		this.name = food.getName();
		this.price = food.getPrice();
		this.typeF = food.getTypeF();
		this.description = food.getDescription();
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


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getTypeF() {
		return typeF;
	}


	public void setTypeF(String typeF) {
		this.typeF = typeF;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
