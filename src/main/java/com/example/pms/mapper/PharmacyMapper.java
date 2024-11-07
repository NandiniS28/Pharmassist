package com.example.pms.mapper;

import org.springframework.stereotype.Component;

import com.example.pms.entity.Pharmacy;
import com.example.pms.requestdtos.PharmacyRequest;
import com.example.pms.responsedtos.PharmacyResponse;

@Component
public class PharmacyMapper {
	
	public Pharmacy mapToPharmacy(PharmacyRequest pharmacyRequest,Pharmacy pharmacy) {
		
		pharmacy.setPharmacyName(pharmacyRequest.getPharmacyName());
		pharmacy.setGstNo(pharmacyRequest.getGstNo());
		pharmacy.setLicenceNo(pharmacyRequest.getLicenseNo());
		
		return pharmacy;	
	}
	
	public PharmacyResponse mapToPharmacyResponse(Pharmacy pharmacy) {
		PharmacyResponse response=new PharmacyResponse();
		
		response.setPharmacyId(pharmacy.getPharmacyId());
	    response.setPharmacyName(pharmacy.getPharmacyName());
	    response.setGstNo(pharmacy.getGstNo());
	   response.setLicenseNo(pharmacy.getLicenceNo());
	    
	    return response;
	}
	
	

}
