package com.isa.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.ticket.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
		User findOneByUsername(String username);
		User findOneByActivationLink(String key);
		User findOneByEmail(String email);
		List<User> findAll();

}
