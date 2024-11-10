package com.example.pms.exception;

public class NoPharmacyFoundException  extends RuntimeException{
	private String message;

	public String getMessage() {
		return message;
	}

	public NoPharmacyFoundException(String message) {
		super();
		this.message = message;
	}

	
	

}
