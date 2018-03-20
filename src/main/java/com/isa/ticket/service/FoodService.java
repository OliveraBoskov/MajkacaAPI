package com.isa.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ticket.domain.Food;
import com.isa.ticket.repository.FoodRepository;


@Service
public class FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	public Food create(Food food) {
		
		foodRepository.save(food);
		return food;
	}
}
