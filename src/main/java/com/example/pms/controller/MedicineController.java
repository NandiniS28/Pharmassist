package com.example.pms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.pms.responsedtos.MedicineResponse;
import com.example.pms.service.MedicineService;
import com.example.pms.util.AppResponseBuilder;
import com.example.pms.util.ErrorStructure;

import com.example.pms.util.ResponseStructure;
import com.example.pms.util.SimpleResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
		return appResponseBuilder.success(HttpStatus.CREATED, message);
		
	}
	@GetMapping("/medicine")
	public ResponseEntity<ResponseStructure<List<MedicineResponse>>> findMedicineByNameOrIngredients(@RequestParam String name){
		List<MedicineResponse> response=medicineService.findMedicineByNameOrIngredients(name);
		return appResponseBuilder.success(HttpStatus.FOUND, "Medicine found Successfully", response);
		
	}


}
