package com.example.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pms.entity.Pharmacy;
@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, String>{

}
