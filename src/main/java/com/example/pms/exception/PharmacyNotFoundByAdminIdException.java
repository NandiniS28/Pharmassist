package com.example.pms.exception;

public class PharmacyNotFoundByAdminIdException  extends RuntimeException{
	private String message;

	public String getMessage() {
		return message;
	}

	public PharmacyNotFoundByAdminIdException(String message) {
		super();
		this.message = message;
	}

	
	

}
