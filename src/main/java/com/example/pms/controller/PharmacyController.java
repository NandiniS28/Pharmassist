package com.example.pms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pms.requestdtos.PharmacyRequest;
import com.example.pms.responsedtos.PharmacyResponse;
import com.example.pms.service.PharmacyService;
import com.example.pms.util.AppResponseBuilder;
import com.example.pms.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class PharmacyController {
	
	private final PharmacyService pharmacyService;
	private final AppResponseBuilder appResponseBuilder;
	
	public PharmacyController(PharmacyService pharmacyService, AppResponseBuilder appResponseBuilder) {
		super();
		this.pharmacyService = pharmacyService;
		this.appResponseBuilder = appResponseBuilder;
	}
	@PostMapping("/admins/{adminId}/pharmacies")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> savePharmacy(@RequestBody @Valid PharmacyRequest pharmacyRequest,@PathVariable String adminId){
	   PharmacyResponse response=pharmacyService.savePharmacy(pharmacyRequest,adminId);
	   return appResponseBuilder.success(HttpStatus.CREATED, "Pharmacy saved", response);
	}
	@GetMapping("/pharmacies/{adminId}")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> findPharmacuByAdminId(@PathVariable String adminId){
		PharmacyResponse response=pharmacyService.findPharmacyByAdminId(adminId);
		return appResponseBuilder.success(HttpStatus.FOUND, "pharmacy associated with admin found", response);
	}
	
	@PutMapping("/pharmacies/{pharmacyId}")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> updatePharmacy(@RequestBody PharmacyRequest pharmacyRequest,@PathVariable String pharmacyId){
		
		PharmacyResponse response=pharmacyService.updatePharmacy(pharmacyRequest,pharmacyId);
		return appResponseBuilder.success(HttpStatus.OK, "pharmacy Updated", response);
			
		
	}
}
