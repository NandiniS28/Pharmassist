package com.example.pms.mapper;

import org.springframework.stereotype.Component;

import com.example.pms.entity.Admin;
import com.example.pms.requestdtos.AdminRequest;
import com.example.pms.responsedtos.AdminResponse;

@Component
public class AdminMapper {
	
	public Admin mapToAdmin(AdminRequest adminRequest, Admin admin) {
		
		admin.setAdminEmail(adminRequest.getAdminEmail());
		admin.setAdminPhoneNo(adminRequest.getAdminPhoneNo());
		admin.setPassword(adminRequest.getPassword());
		
		return admin;
		
	}
	
	public AdminResponse mapToAdminResponse(Admin admin) {
		
		AdminResponse response=new AdminResponse();
		response.setAdminId(admin.getAdminId());
		response.setAdminEmail(admin.getAdminEmail());
		
		return response;
		
	}

}
