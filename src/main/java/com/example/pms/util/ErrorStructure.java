package com.example.pms.util;

public class ErrorStructure<T> {
	private int statusCode;
	private String message;
	private T rootCause;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getRootCause() {
		return rootCause;
	}
	public void setRootCause(T rootCause) {
		this.rootCause = rootCause;
	}
	 public static<T>ErrorStructure<T> create(int statusCode,String message,T rootCause){
		 ErrorStructure error=new ErrorStructure();
		 error.setStatusCode(statusCode);
		 error.setMessage(message);
		 error.setRootCause(rootCause);
		 return error;
	 }

}
