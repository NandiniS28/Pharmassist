package com.example.pms.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pms.exception.AdminNotFoundByIdException;
import com.example.pms.exception.NoAdminFoundException;
import com.example.pms.util.AppResponseBuilder;
import com.example.pms.util.ErrorStructure;

@RestControllerAdvice
public class AdminExceptionHandler {
	
	private final AppResponseBuilder appResponseBuilder;

	public AdminExceptionHandler(AppResponseBuilder appResponseBuilder) {
		super();
		this.appResponseBuilder = appResponseBuilder;
	}
	@ExceptionHandler(AdminNotFoundByIdException.class)
	public static ResponseEntity<ErrorStructure> handleAdnimNotFoundById(AdminNotFoundByIdException ex){
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage(),"Admin not found by Id");
	}
	@ExceptionHandler(NoAdminFoundException.class)
	public static ResponseEntity<ErrorStructure> handleNoAdminsFound(NoAdminFoundException ex){
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Admin not found under requested criteria");
	}

}
