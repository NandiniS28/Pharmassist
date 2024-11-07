package com.example.pms.service;

import org.springframework.stereotype.Service;

import com.example.pms.entity.Admin;
import com.example.pms.entity.Pharmacy;
import com.example.pms.exception.AdminNotFoundByIdException;
import com.example.pms.exception.PharmacyNotFoundByAdminIdException;
import com.example.pms.exception.PharmacyNotFoundByIdException;
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
	public PharmacyResponse findPharmacyByAdminId(String adminId) {
		Admin admin=adminRepository.findById(adminId).
		orElseThrow(()->new AdminNotFoundByIdException("admin not found by this id"));
		
		Pharmacy pharmacy=adminRepository.findPharmacyByAdminId(adminId);
		if(pharmacy==null) {
			throw new PharmacyNotFoundByAdminIdException("pharmacy not found by admin Id"+adminId);
		}
		return pharmacyMapper.mapToPharmacyResponse(pharmacy);
	}
	
        public PharmacyResponse updatePharmacy(PharmacyRequest pharmacyRequest, String pharmacyId) {
		
		return pharmacyRepository.findById(pharmacyId)
				.map(exPharmacy->{
			pharmacyMapper.mapToPharmacy(pharmacyRequest, exPharmacy);
			return pharmacyRepository.save(exPharmacy);
		})
				.map(pharmacyMapper::mapToPharmacyResponse).
				orElseThrow(()->new PharmacyNotFoundByIdException("failed to update Pharmacy"));
		
		//pharmacyNotFoundByIdException should extends with runtime exception
	
	}	
	
}

	
	
    

