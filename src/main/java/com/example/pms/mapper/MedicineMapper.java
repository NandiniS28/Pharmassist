package com.example.pms.mapper;

import org.springframework.stereotype.Component;

import com.example.pms.entity.Medicine;
import com.example.pms.requestdtos.MedicineRequest;
import com.example.pms.responsedtos.MedicineResponse;


@Component
public class MedicineMapper {
	
	public Medicine mapToMedicine(MedicineRequest medicineRequest,Medicine medicine) {
		
		medicine.setName(medicineRequest.getName());
		medicine.setCategory(medicineRequest.getCategory());
		medicine.setDosageInMg(medicineRequest.getDosageInMg());
		medicine.setExpiryDate(medicineRequest.getExpiryDate());
		medicine.setForm(medicineRequest.getForm());
		medicine.setIngredients(medicineRequest.getIngredients());
		medicine.setPrice(medicineRequest.getPrice());
		medicine.setManufacturer(medicineRequest.getManufacturer());
		medicine.setStockQuantity(medicineRequest.getStockQuantity());
		
		return medicine;
	}
	public MedicineResponse mapToMedicineResponse(Medicine medicine) {
		return new com.example.pms.responsedtos.MedicineResponse(medicine.getMedicineId(), medicine.getName(), medicine.getCategory(),
				medicine.getIngredients(), medicine.getDosageInMg(), medicine.getForm(), medicine.getManufacturer(),
				medicine.getStockQuantity(), medicine.getExpiryDate(), medicine.getPrice());

	}

}
