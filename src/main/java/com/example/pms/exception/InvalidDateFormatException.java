package com.example.pms.exception;

public class InvalidDateFormatException extends RuntimeException {
	
	private final String message;
	
		public String getMessage() {
			return message;
		}
	
		public InvalidDateFormatException(String message) {
			super();
			this.message = message;
		}

}
