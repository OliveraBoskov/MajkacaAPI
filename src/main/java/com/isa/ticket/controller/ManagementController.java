package com.isa.ticket.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ticket.controller.dto.GetJobApplicationsDTO;
import com.isa.ticket.controller.dto.JobApplicationDTO;
import com.isa.ticket.controller.dto.ResponseMessageDTO;
import com.isa.ticket.domain.JobApplication;
import com.isa.ticket.domain.User;
import com.isa.ticket.repository.UserRepository;
import com.isa.ticket.service.MailService;
import com.isa.ticket.service.ManagementService;
import com.isa.ticket.utils.UserUtils;

@RestController
@RequestMapping("/management")
public class ManagementController {
	
	@Autowired
	private ManagementService managementService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private UserUtils userUtils;

	
	@PostMapping("{id}/applyForJob")
	public ResponseMessageDTO applyForJob(@RequestBody JobApplicationDTO jobApplicationDTO, @PathVariable("id") Long id) {
		
		User user = userRepository.findOneByUsername(userUtils.getCurrentUserAsUser().getUsername());
		
		
		managementService.createApplication(user, jobApplicationDTO.getPosition(), jobApplicationDTO.getDescription(), id);
		
		
		return new ResponseMessageDTO("Uspesno ste se prijavili za posao!");
	}
	
	
	@GetMapping("{id}/getJobApplications")
	public GetJobApplicationsDTO getJobApplications(@PathVariable("id") Long id, String status){
		List<JobApplication> tempList = managementService.getAllByRestaurantAndStatus(id, status);
		System.out.println(tempList);
		return new GetJobApplicationsDTO(tempList, "uspesno");
	}
	
	@GetMapping("{idR}/accepted/{idA}") //idRestorana, idAplikacije
	public void acceptingJobApplication(@PathVariable("idR") Long idR, @PathVariable("idA") Long idA) throws MessagingException{
		JobApplication jobApplicaton = managementService.acceptJobApplication(idA);
		
		mailService.sendJobApplicationMail(jobApplicaton.getUser(), true);
		
	}
	
	@GetMapping("{idR}/denied/{idA}")
	public void denyingJobApplication(@PathVariable("idR") Long idR, @PathVariable("idA") Long idA) throws MessagingException{
		JobApplication jobApplication = managementService.denyJobApplication(idA);
		
		mailService.sendJobApplicationMail(jobApplication.getUser(), false);
	}
	
	
	
	
	
}
