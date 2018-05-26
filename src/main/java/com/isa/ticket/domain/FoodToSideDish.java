package com.isa.ticket.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FoodToSideDish {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Food food;
	
	@ManyToOne
	private SideDish sideDish;

	public FoodToSideDish() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public SideDish getSideDish() {
		return sideDish;
	}

	public void setSideDish(SideDish sideDish) {
		this.sideDish = sideDish;
	}
	
	

}
