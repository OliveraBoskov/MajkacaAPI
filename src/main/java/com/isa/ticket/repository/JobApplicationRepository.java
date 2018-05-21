package com.isa.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.ticket.domain.JobApplication;
import com.isa.ticket.domain.Restaurant;
import com.isa.ticket.domain.User;

public interface JobApplicationRepository extends JpaRepository <JobApplication, Long>{
	
	JobApplication findOneByUserAndPositionAndRestaurant(User u,String position,Restaurant restaurant);
	List<JobApplication> findAllByIdAndStatus(Long id, String status);
	JobApplication findOneById(Long idA);

}
