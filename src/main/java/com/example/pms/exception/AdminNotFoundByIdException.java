package com.example.pms.exception;

public class AdminNotFoundByIdException  extends RuntimeException{
	
	private final String message;

	public AdminNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
