package com.example.pms.exception;

public class NoMedicinesFoundException extends RuntimeException{
	

	private String message;

	public NoMedicinesFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
