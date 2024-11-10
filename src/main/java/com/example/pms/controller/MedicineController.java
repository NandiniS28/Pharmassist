package com.example.pms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.pms.service.MedicineService;
import com.example.pms.util.AppResponseBuilder;
import com.example.pms.util.SimpleResponseStructure;

@Controller
public class MedicineController {
	private final MedicineService medicineService;
	private final AppResponseBuilder appResponseBuilder;
	
	public MedicineController(MedicineService medicineService, AppResponseBuilder appResponseBuilder) {
		super();
		this.medicineService = medicineService;
		this.appResponseBuilder = appResponseBuilder;
	}
	
	@PostMapping("/pharmacies/{pharmacyId}/medicines")
	public ResponseEntity<SimpleResponseStructure> uploadMedicines(@RequestParam("medicine_info") MultipartFile file,@PathVariable String pharmacyId) {
		
		String message = medicineService.uploadMedicines(file, pharmacyId);
		return AppResponseBuilder.success(HttpStatus.CREATED, message);
		
	}
}
