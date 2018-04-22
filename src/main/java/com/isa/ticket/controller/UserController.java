package com.isa.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ticket.controller.dto.JobApplicationDTO;
import com.isa.ticket.domain.User;
import com.isa.ticket.repository.UserRepository;
import com.isa.ticket.service.ManagementService;

@RestController
@RequestMapping("/account")
public class UserController {
	
	@Autowired
	private ManagementService managementService;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/restorani/{id}/sendApplication")
	@ResponseStatus(HttpStatus.CREATED)
	public void sendApplication(@RequestBody JobApplicationDTO jobApplicationDTO, @PathVariable("id") Long restaurantID) {
		User user = userRepository.findAll().get(0);
		managementService.createApplication(user, jobApplicationDTO.getPosition(), jobApplicationDTO.getDescription(), restaurantID);
	}

}
