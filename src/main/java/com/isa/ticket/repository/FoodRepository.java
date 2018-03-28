package com.isa.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ticket.domain.Food;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
	
	
}
