package com.isa.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ticket.domain.JobApplication;
import com.isa.ticket.domain.Restaurant;
import com.isa.ticket.domain.User;
import com.isa.ticket.repository.JobApplicationRepository;
import com.isa.ticket.repository.RestaurantRepository;
import com.isa.ticket.utils.ApplicationConstants;

@Service
public class ManagementService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private JobApplicationRepository jobApplicationRepository;
	
	public JobApplication createApplication(User user, String position, String description, Long id){
		Restaurant restaurant = restaurantRepository.findOneById(id);
		JobApplication jobApplication = jobApplicationRepository.findOneByUserAndPositionAndRestaurant(user, position, restaurant);
		
		if(jobApplication != null)
			throw new IllegalArgumentException("Aplikacija za ovaj posao vec postoji");
		
		jobApplication = new JobApplication();
		
		jobApplication.setUser(user);
		jobApplication.setPosition(position);
		jobApplication.setDescription(description);
		jobApplication.setRestaurant(restaurant);
		jobApplication.setStatus(ApplicationConstants.JOBAPPLICATION_STATUS);
		
		return jobApplicationRepository.save(jobApplication);
		
	}
	
	public List<JobApplication> getAllByRestaurantAndStatus(Long id, String status){
		List<JobApplication> jobApplication = jobApplicationRepository.findAllByIdAndStatus(id, status);
		return jobApplication;
	}
	
	public JobApplication acceptJobApplication(Long idA){
		JobApplication jobApplication = jobApplicationRepository.findOneById(idA);
		
		if(jobApplication == null)
			throw new IllegalArgumentException("Aplikacija za ovaj posao vec postoji");
		jobApplication.setStatus(ApplicationConstants.JOBAPPLICATION_STATUS_ACCEPTED);
		return jobApplicationRepository.save(jobApplication);
		
	}
	
	public JobApplication denyJobApplication(Long idA){
		JobApplication jobApplication = jobApplicationRepository.findOneById(idA);
		
		if(jobApplication == null)
			throw new IllegalArgumentException("Aplikacija za ovaj posao vec postoji");
		jobApplication.setStatus(ApplicationConstants.JOBAPPLICATION_STATUS_DENIED);
		return jobApplicationRepository.save(jobApplication);
	}
}
