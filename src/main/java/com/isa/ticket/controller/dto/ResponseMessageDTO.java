package com.isa.ticket.controller.dto;

public class ResponseMessageDTO {
	private String message;

	public ResponseMessageDTO() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseMessageDTO(String message) {
		super();
		this.message = message;
	}
	

}
