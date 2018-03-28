package com.isa.ticket.controller.dto;

public class SideDishDTO {
	
	private String name;
	private Long price;
	public SideDishDTO(String name, Long price) {
		super();
		this.name = name;
		this.price = price;
	}
	public SideDishDTO() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	
	

}
