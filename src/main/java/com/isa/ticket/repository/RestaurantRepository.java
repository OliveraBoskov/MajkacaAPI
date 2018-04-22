package com.isa.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ticket.domain.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	Restaurant findOneById(Long id);
	Restaurant findByName(String name);
	List<Restaurant> findAll();
}
