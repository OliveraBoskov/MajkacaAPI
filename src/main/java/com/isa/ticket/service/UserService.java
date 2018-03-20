package com.isa.ticket.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ticket.domain.User;
import com.isa.ticket.repository.UserRepository;

@Service

public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User registration(User user){
		
		user.setActive(false);
		user.setRole("USER");
		user.setActivationLink(UUID.randomUUID().toString());
		
		userRepository.save(user);
		
		return user;
	}
	
	public User checkIfExists(String username){
		User user = userRepository.findByUsername(username);
		return user;
	}
	
	public User userActivation(String key){
		User user = userRepository.findByActivationLink(key);
		if(user== null){
			return null;
		}
		
		user.setActive(true);
		user.setActivationLink(null);
		userRepository.save(user);
		return user;
	}
	
	public User deleteAccount(String email) {
		return null;
	}

}
