package com.isa.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ticket.controller.dto.AddSideDishDTO;
import com.isa.ticket.controller.dto.DeleteDTO;
import com.isa.ticket.controller.dto.DeleteSideDishDTO;
import com.isa.ticket.controller.dto.ResponseMessageDTO;
import com.isa.ticket.domain.SideDish;
import com.isa.ticket.domain.User;
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
		
		sideDish = sideDishService.addSideDish(sideDish);
		
		return new ResponseMessageDTO("Uspesno dodat prilog!");

	}
	
	@PostMapping("/deleteSideDish")
	public ResponseMessageDTO deleteSideDish(@RequestBody DeleteSideDishDTO deleteSideDishDTO){
		SideDish sideDish = sideDishService.deleteSideDish(deleteSideDishDTO.getName(), 
							deleteSideDishDTO.getPrice(), deleteSideDishDTO.isAvailable());
		if(sideDish == null){
			return new ResponseMessageDTO("Neuspesno brisanje priloga!");
		}
		
		return new ResponseMessageDTO("Uspesno ste obrisali prilog!");
	}
	

}
