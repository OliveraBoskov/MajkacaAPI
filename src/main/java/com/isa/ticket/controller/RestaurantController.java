package com.isa.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ticket.controller.dto.CreateRestaurantDTO;
import com.isa.ticket.controller.dto.GetRestaurantsDTO;
import com.isa.ticket.controller.dto.ResponseMessageDTO;
import com.isa.ticket.controller.dto.RestaurantDTO;
import com.isa.ticket.domain.Restaurant;
import com.isa.ticket.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/createRestaurant")
	public ResponseMessageDTO createRestaurant(@RequestBody CreateRestaurantDTO createRestaurantDTO) {
		Restaurant restaurant = new Restaurant();
		
		restaurant.setName(createRestaurantDTO.getName());
		restaurant.setLocation(createRestaurantDTO.getLocation());
		restaurant.setPhoneNumber(createRestaurantDTO.getPhoneNumber());
		restaurant.setDescription(createRestaurantDTO.getDescription());
		
		restaurant = restaurantService.create(restaurant);
		
		return new ResponseMessageDTO("Uspesno dodat restoran!");
	}
	
	@GetMapping("/getRestaurants")
	public GetRestaurantsDTO getRestaurants() {
		List<Restaurant> tempList = restaurantService.getAll();
		System.out.println(tempList);
		return new GetRestaurantsDTO("Uspesno",tempList);
	}
	
	@GetMapping("/profile/{name}")
	public RestaurantDTO getSelectedRestaurant(@PathVariable("name") String name){
		Restaurant restaurant = restaurantService.getSelectedRestaurant(name);
		return new RestaurantDTO(restaurant.getName(), restaurant.getLocation());
	}
	
	
}
