package com.example.pms.mapper;

import org.springframework.stereotype.Component;

import com.example.pms.entity.Patient;
import com.example.pms.requestdtos.PatientRequest;
import com.example.pms.responsedtos.PatientResponse;

@Component
public class PatientMapper {
	
	public Patient mapToPatient(PatientRequest patientRequest,Patient patient) {
		patient.setPatientName(patientRequest.getPatientName());
		patient.setPatientPhoneNo(patientRequest.getPatientPhoneNo());
		patient.setPatientEmail(patientRequest.getPatientEmail());
		patient.setPatientGender(patientRequest.getPatientGender());
		patient.setPatientDateOfBirth(patientRequest.getPatientDateOfBirth());
		
		return patient;
	}
	public PatientResponse mapToPatientResponse(Patient patient) {
		
		PatientResponse response= new PatientResponse();
		response.setPatientId(patient.getPatientId());
		response.setPatientName(patient.getPatientName());
		response.setPatientPhoneNo(patient.getPatientPhoneNo());
		response.setPatientEmail(patient.getPatientEmail());
		response.setPatientGender(patient.getPatientGender());
		response.setPatientDateOfBirth(patient.getPatientDateOfBirth());
		
		return response;
	}

}
