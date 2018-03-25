package com.isa.ticket.controller.dto;

public class DeleteSideDishDTO {
	private String name;
	private Long price;
	private boolean available;
	
	public DeleteSideDishDTO() {
		super();
	}
	public DeleteSideDishDTO(String name, Long price, boolean available) {
		super();
		this.name = name;
		this.price = price;
		this.available = available;
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
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
}
