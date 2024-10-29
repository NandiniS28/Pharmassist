package com.example.pms.util;

import org.springframework.http.HttpStatus;

public class ResponseStructure<T> {
	
	private int statusCode;
	private String message;
	private T data;
	
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public static <T>ResponseStructure<T> create(HttpStatus status,String message,T data){
		ResponseStructure<T> response=new ResponseStructure<T>();
		response.setData(data);
		response.setStatusCode(status.value());
		response.setMessage(message);
		
		return response;
	}

}
