package com.isa.ticket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ticket.domain.Food;
import com.isa.ticket.domain.FoodToSideDish;
import com.isa.ticket.domain.SideDish;
import com.isa.ticket.repository.FoodRepository;
import com.isa.ticket.repository.FoodToSideDishRepository;
import com.isa.ticket.repository.SideDishRepository;


@Service
public class FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private SideDishRepository sideDishRepository;
	
	@Autowired
	private FoodToSideDishRepository foodToSideDishRepository;
	
	
	public Food create(Food food) {
		
		foodRepository.save(food);
		
		
		return food;
	}
	
	public void setRelationshipBetweenFoodAndSideDish(Long foodId, ArrayList<Long> sideDishIds){
		Food food = foodRepository.findOneById(foodId);
		List<SideDish> sideDishes = new ArrayList<>();
		for(Long sideDishId: sideDishIds){
			SideDish sideDish = sideDishRepository.findOneById(sideDishId);
			
			FoodToSideDish foodToSideDish = new FoodToSideDish();
			foodToSideDish.setFood(food);
			foodToSideDish.setSideDish(sideDish);
			
			foodToSideDishRepository.save(foodToSideDish);
		}
	}
	
	public List<Food> getAll() {
		return foodRepository.findAll();
	}
	
	public Food deleteFood(String name) {
		Food food = foodRepository.findByName(name);
		
		foodRepository.delete(food);
		
		return food;
	}
	
	public Food getSingleFood(Long id) {
		Food food = foodRepository.findOneById(id);
		return food;
	}
}
