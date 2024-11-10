package com.example.pms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.pms.requestdtos.PatientRequest;
import com.example.pms.responsedtos.PatientResponse;
import com.example.pms.service.PatientService;
import com.example.pms.util.AppResponseBuilder;
import com.example.pms.util.ResponseStructure;

@RestController
public class PatientController {
	
	private final PatientService patientService;
	private final AppResponseBuilder appResponseBuilder;
	public PatientController(PatientService patientService, AppResponseBuilder appResponseBuilder) {
		super();
		this.patientService = patientService;
		this.appResponseBuilder = appResponseBuilder;
	}
	@PostMapping("/pharmacies/{pharmacyId}")
	public ResponseEntity<ResponseStructure<PatientResponse>> addPatients(@RequestBody PatientRequest patientRequest, @PathVariable String pharmacyId)
	{
		PatientResponse response=patientService.addPatients(patientRequest,pharmacyId);
		return appResponseBuilder.success(HttpStatus.CREATED, "patient Registered", response);	
	}
	@PutMapping("patients/{patientId}")
	public ResponseEntity<ResponseStructure<PatientResponse>> updatePatient(@RequestBody PatientRequest patientRequest, @PathVariable String patientId) {
		
		PatientResponse response = patientService.updatePatient(patientRequest, patientId);
		return appResponseBuilder.success(HttpStatus.OK,"Patient Updated", response);
		
	}
}
