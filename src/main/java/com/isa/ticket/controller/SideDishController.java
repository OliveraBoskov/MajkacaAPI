package com.isa.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ticket.controller.dto.AddSideDishDTO;
import com.isa.ticket.controller.dto.ResponseMessageDTO;
import com.isa.ticket.domain.SideDish;
import com.isa.ticket.service.SideDishService;

@RestController
@RequestMapping("/sideDish")
public class SideDishController {
	
	@Autowired
	private SideDishService sideDishService;
	
	@PostMapping("/addSideDish")
	public ResponseMessageDTO addSideDish(@RequestBody AddSideDishDTO addSideDishDTO){
		SideDish sideDish = new SideDish();
		sideDish.setName(addSideDishDTO.getName());
		sideDish.setPrice(addSideDishDTO.getPrice());
		sideDish.setAvailable(addSideDishDTO.isAvailable());
		
		return null;

	}

}
