package com.example.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import com.example.pms.entity.Admin;
import com.example.pms.entity.Pharmacy;

@Repository
public interface AdminRepository  extends JpaRepository<Admin, String>{

	//HQL query to select the pharmacy associated with the admin

		@Query("SELECT a.pharmacy FROM Admin a WHERE a.id= adminId")
	   Pharmacy findPharmacyByAdminId(String adminId);

		
		Optional<Admin> findByAdminEmail(String username);


		



}
