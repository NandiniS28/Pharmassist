package com.example.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pms.entity.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, String>{

}
