package com.isa.ticket.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.isa.ticket.domain.SideDish;

public class GetSideDishesDTO {
	
	private List<SideDish> sideDishes = new ArrayList<SideDish>();
	private String message;
	
	
	public GetSideDishesDTO(List<SideDish> sideDishes, String message) {
		this.sideDishes = sideDishes;
		this.message = message;
	}


	public GetSideDishesDTO() {
		super();
	}


	public List<SideDish> getSideDishes() {
		return sideDishes;
	}


	public void setSideDishes(List<SideDish> sideDishes) {
		this.sideDishes = sideDishes;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
