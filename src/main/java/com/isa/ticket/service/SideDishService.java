package com.isa.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ticket.domain.SideDish;
import com.isa.ticket.domain.User;
import com.isa.ticket.repository.SideDishRepository;


@Service

public class SideDishService {
	
	@Autowired
	private SideDishRepository sideDishRepository;
	
	public SideDish addSideDish(SideDish sideDish) {
		
		sideDishRepository.save(sideDish);
		return sideDish;
	}
	
	
	public SideDish deleteSideDish(String name, Long price, boolean available) {
		SideDish sideDish = sideDishRepository.findByName(name);
		
		sideDishRepository.delete(sideDish);
		
		return sideDish;
	}
	
	

}
