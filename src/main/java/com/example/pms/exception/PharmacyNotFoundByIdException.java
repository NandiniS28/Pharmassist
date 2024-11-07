package com.example.pms.exception;

public class PharmacyNotFoundByIdException extends RuntimeException{
	private final String message;

	public String getMessage() {
		return message;
	}

	public PharmacyNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	

}
