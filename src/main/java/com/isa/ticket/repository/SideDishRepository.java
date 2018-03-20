package com.isa.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ticket.domain.SideDish;

@Repository
public interface SideDishRepository extends JpaRepository<SideDish, Long>{

}
