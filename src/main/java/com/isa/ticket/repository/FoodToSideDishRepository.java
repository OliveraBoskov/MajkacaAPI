package com.isa.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ticket.domain.FoodToSideDish;

@Repository
public interface FoodToSideDishRepository extends JpaRepository<FoodToSideDish, Long> {

}
