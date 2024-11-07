package com.example.pms.service;

import org.springframework.stereotype.Service;

import com.example.pms.entity.Admin;
import com.example.pms.entity.Pharmacy;
import com.example.pms.exception.AdminNotFoundByIdException;
import com.example.pms.exception.PharmacyNotFoundByAdminIdException;
import com.example.pms.mapper.PharmacyMapper;
import com.example.pms.repository.AdminRepository;
import com.example.pms.repository.PharmacyRepository;
import com.example.pms.requestdtos.PharmacyRequest;
import com.example.pms.responsedtos.PharmacyResponse;

@Service
public class PharmacyService {
	
	private final PharmacyRepository pharmacyRepository;
	private final PharmacyMapper pharmacyMapper;
	private final AdminRepository adminRepository;
	
	public PharmacyService(PharmacyRepository pharmacyRepository, PharmacyMapper pharmacyMapper,AdminRepository adminRepository) {
		super();
		this.pharmacyRepository = pharmacyRepository;
		this.pharmacyMapper = pharmacyMapper;
		this.adminRepository=adminRepository;
	}

	public PharmacyResponse savePharmacy(PharmacyRequest pharmacyRequest,String adminId) {
	
		return adminRepository.findById(adminId).map(admin->{
			Pharmacy pharmacy=pharmacyMapper.mapToPharmacy(pharmacyRequest, new Pharmacy());
			pharmacy=pharmacyRepository.save(pharmacy);
		    admin.setPharmacy(pharmacy);
			adminRepository.save(admin);
			return pharmacyMapper.mapToPharmacyResponse(pharmacy);
			
		})
				.orElseThrow(()->new AdminNotFoundByIdException("failed to fing Admin"));
	
		
	}

	

	
	
    
}
