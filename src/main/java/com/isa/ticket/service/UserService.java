package com.isa.ticket.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isa.ticket.domain.User;
import com.isa.ticket.repository.UserRepository;

@Service

public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User registration(User user){
		
		user.setActive(false);
		user.setRole("USER");
		user.setActivationLink(UUID.randomUUID().toString());
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		
		
		userRepository.save(user);
		return user;
	}
	
	public User checkIfExists(String username){
		User user = userRepository.findOneByUsername(username);
		return user;
	}
	
	public User userActivation(String key){
		User user = userRepository.findOneByActivationLink(key);
		if(user== null){
			return null;
		}
		
		user.setActive(true);
		user.setActivationLink(null);
		userRepository.save(user);
		return user;
	}
	
	public User deleteAccount(String email, String password) {
		User user = userRepository.findOneByEmail(email);
		if(!user.getPassword().equals(password)){
				return null;
		}else{
			userRepository.delete(user);
			return user;
		}
	}
	
	public User editUser(String email, String password, String username){
		User user = userRepository.findOneByUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		userRepository.save(user);
		
		return user;
	}
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User getSelectedUser(String email){
		User user = userRepository.findOneByEmail(email);
		return user;
	}
	
	public void activateAccount(String key){
		User user = userRepository.findOneByActivationLink(key);
		user.setActive(true);
		user.setActivationLink(null);
		userRepository.save(user);
	}
	
}
