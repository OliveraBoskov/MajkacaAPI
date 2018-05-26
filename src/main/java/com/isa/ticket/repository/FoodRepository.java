package com.isa.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ticket.domain.Food;
import com.isa.ticket.domain.SideDish;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
	Food findByName(String name);
	Food findOneById(Long id);
	
}
