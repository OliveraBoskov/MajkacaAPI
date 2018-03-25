package com.isa.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ticket.domain.SideDish;
import com.isa.ticket.repository.SideDishRepository;


@Service

public class SideDishService {
	
	@Autowired
	private SideDishRepository sideDishRepository;
	
	public SideDish create(SideDish sideDish) {
		
		sideDishRepository.save(sideDish);
		return sideDish;
	}
	
	

}
