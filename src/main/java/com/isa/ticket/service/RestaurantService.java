package com.isa.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ticket.domain.Restaurant;
import com.isa.ticket.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public Restaurant create(Restaurant restaurant) {
		
		restaurantRepository.save(restaurant);
		return restaurant;
	}
	
	
	public List<Restaurant> getAll() {
		return restaurantRepository.findAll();
	}
	
	public Restaurant getSelectedRestaurant(String name){
		Restaurant restaurant = restaurantRepository.findByName(name);
		return restaurant;
	}
	
	public Restaurant getSingleRestaurant(Long id) {
		Restaurant restaurant = restaurantRepository.findOneById(id);
		return restaurant;
	}


}
