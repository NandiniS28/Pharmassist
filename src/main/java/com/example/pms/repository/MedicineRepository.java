package com.example.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pms.entity.Medicine;
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, String> {

	List<Medicine> findByNameLikeIgnoreCaseOrIngredientsLikeIgnoreCase(String text, String text2); 
		

}
