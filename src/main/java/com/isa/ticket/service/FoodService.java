package com.isa.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ticket.domain.Food;
import com.isa.ticket.domain.Restaurant;
import com.isa.ticket.domain.SideDish;
import com.isa.ticket.repository.FoodRepository;


@Service
public class FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	public Food create(Food food) {
		
		foodRepository.save(food);
		return food;
	}
	
	public List<Food> getAll() {
		return foodRepository.findAll();
	}
	
	public Food deleteFood(String name) {
		Food food = foodRepository.findByName(name);
		
		foodRepository.delete(food);
		
		return food;
	}
}
