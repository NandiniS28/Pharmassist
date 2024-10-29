package com.example.pms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pms.requestdtos.AdminRequest;
import com.example.pms.responsedtos.AdminResponse;
import com.example.pms.service.AdminService;
import com.example.pms.util.AppResponseBuilder;
import com.example.pms.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	
	private final AdminService adminService;
	private final AppResponseBuilder appResponseBuilder;
	
	public AdminController(AdminService adminService, AppResponseBuilder appResponseBuilder) {
		super();
		this.adminService = adminService;
		this.appResponseBuilder = appResponseBuilder;
	}
	
	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody @Valid AdminRequest adminRequest){
		 AdminResponse response=adminService.saveAdmin(adminRequest);
		 return appResponseBuilder.success(HttpStatus.CREATED, "admin Created", response);
	}

}
