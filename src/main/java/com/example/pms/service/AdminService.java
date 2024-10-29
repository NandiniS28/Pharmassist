package com.example.pms.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.pms.entity.Admin;
import com.example.pms.mapper.AdminMapper;
import com.example.pms.repository.AdminRepository;
import com.example.pms.requestdtos.AdminRequest;
import com.example.pms.responsedtos.AdminResponse;

@Service
public class AdminService {
	
	private final AdminRepository adminRepository;
	private final AdminMapper adminMapper;
	
	public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
	}
	
	public AdminResponse saveAdmin(AdminRequest adminRequest) {
		 Admin admin=adminRepository.save(adminMapper.mapToAdmin(adminRequest, new Admin()));
		 return adminMapper.mapToAdminResponse(admin);
		
	}

	public List<AdminResponse> findAllAdmins() {
		
		return adminRepository.findAll().stream().map(adminMapper::mapToAdminResponse).toList();
	}

}
