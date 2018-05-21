package com.isa.ticket.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ticket.domain.User;
import com.isa.ticket.repository.UserRepository;
import com.isa.ticket.security.SecurityUtils;

@Service

public class UserUtils {
	@Autowired
	private UserRepository userRepository;
	
	
	public User getCurrentUserAsUser() {
		String username = SecurityUtils.getCurrentUserLoginByUsername().get();
		return userRepository.findOneByUsername(username);
	}
}
