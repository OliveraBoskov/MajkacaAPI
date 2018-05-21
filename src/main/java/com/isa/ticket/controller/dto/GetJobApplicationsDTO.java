package com.isa.ticket.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.isa.ticket.domain.JobApplication;

public class GetJobApplicationsDTO {

	private String message;
	private List<JobApplication> jobApplications = new ArrayList<JobApplication>();
	
	public GetJobApplicationsDTO() {
		super();
	}
	

	public GetJobApplicationsDTO(List<JobApplication> jobApplications, String message) {
		super();
		this.jobApplications = jobApplications;
		this.message = message;
	}



	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
