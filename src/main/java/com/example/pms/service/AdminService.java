package com.example.pms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.pms.entity.Admin;
import com.example.pms.exception.AdminNotFoundByIdException;
import com.example.pms.exception.NoAdminFoundException;
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
		List<Admin> admins=adminRepository.findAll();
		if(admins.isEmpty())
			throw new NoAdminFoundException("No admins Present");
		else {
		return admins.stream().map(adminMapper::mapToAdminResponse).toList();
	}
	}
	public AdminResponse findAdminById(String adminId) {
		 Optional<Admin> optional=adminRepository.findById(adminId);
		 if(optional.isPresent()) {
			 return adminMapper.mapToAdminResponse(optional.get());
		 }
		 else {
		throw new AdminNotFoundByIdException("failed to find user");
		 }
	}

	public AdminResponse UpdateAdmin(AdminRequest adminRequest, String adminId) {
		Optional<Admin> optional=adminRepository.findById(adminId);
		if(optional.isPresent()) {
			Admin admin=adminRepository.save(adminMapper.mapToAdmin(adminRequest, optional.get()));
		    return adminMapper.mapToAdminResponse(admin);
		}
		else {
			throw new AdminNotFoundByIdException("Failed to Update user");
		}
		
	}
//	public  AdminResponse deleteAdmin(String adminId) {
//	Optional<Admin> optional=adminRepository.findById(adminId);
//	if(optional.isPresent()) {
//		Admin admin=optional.get();
//				adminRepository.deleteById(adminId);
//		return adminMapper.mapToAdminResponse(admin);
//		
//	}
//	else {
//		throw new AdminNotFoundByIdException("failed to delete the Admin");
//	}
		
//	}

}
