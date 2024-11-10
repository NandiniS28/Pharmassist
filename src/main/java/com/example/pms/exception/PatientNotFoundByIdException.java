package com.example.pms.exception;

public class PatientNotFoundByIdException  extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}
	public PatientNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	

}
