package com.example.pms.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.pms.entity.Medicine;
import com.example.pms.entity.Pharmacy;
import com.example.pms.enums.Form;
import com.example.pms.exception.InvalidDataException;
import com.example.pms.exception.InvalidDateFormatException;
import com.example.pms.exception.InvalidFileFormatException;
import com.example.pms.exception.NoMedicinesFoundException;
import com.example.pms.exception.PharmacyNotFoundByIdException;
import com.example.pms.mapper.MedicineMapper;
import com.example.pms.repository.MedicineRepository;
import com.example.pms.repository.PharmacyRepository;
import com.example.pms.responsedtos.MedicineResponse;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class MedicineService{
	
	private final MedicineRepository medicineRepository;
	private final MedicineMapper medicineMapper;
	private final PharmacyRepository pharmacyRepository;
	
	
	public MedicineService(MedicineRepository medicineRepository, MedicineMapper medicineMapper,
			PharmacyRepository pharmacyRepository) {
		super();
		this.medicineRepository = medicineRepository;
		this.medicineMapper = medicineMapper;
		this.pharmacyRepository = pharmacyRepository;
	}

	@Transactional
	public String uploadMedicines(MultipartFile file,String pharmacyId) {

		Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
				.orElseThrow(()-> new PharmacyNotFoundByIdException("Failed to find pharmacy with Id"+pharmacyId));

		try(XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {

			for(Sheet sheet : workbook) {
				for(Row row : sheet) {
					if(row.getRowNum()!=0)
					{
						Medicine medicine = new Medicine();

						getMedicine(medicine,row);

						medicine.setPharmacy(pharmacy);

						saveMedicine(medicine);

						pharmacy.getMedicines().add(medicine);										
					}
				}
			}

		}catch ( NotOfficeXmlFileException | IOException e) {
			throw new InvalidFileFormatException("Invalid file format");
		}

		return "Medicines Added";
	}


	public void getMedicine(Medicine medicine, Row row) {


		try {
			medicine.setName(row.getCell(0).getStringCellValue());
			medicine.setCategory(row.getCell(1).getStringCellValue());
			medicine.setDosageInMg((int) row.getCell(2).getNumericCellValue());
			medicine.setForm(Form.valueOf
					(row.getCell(3).getStringCellValue().toUpperCase()));
			medicine.setIngredients(row.getCell(4).getStringCellValue());
			medicine.setManufacturer(row.getCell(5).getStringCellValue());
			medicine.setPrice(row.getCell(6).getNumericCellValue());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			medicine.setExpiryDate(LocalDate.parse(row.getCell(7).getStringCellValue(), formatter));
//			medicine.setStockQuantity((int) row.getCell(8).getNumericCellValue());
			medicine.setStockQuantity(ThreadLocalRandom.current().nextInt(50, 101));

		}
		catch(NumberFormatException e) {
			throw new InvalidDataException("Data is in invalid format in row "+row.getRowNum());
		}
		 catch(IllegalStateException e) {
			throw new InvalidDataException("Data is in invalid format in row "+row.getRowNum() );
		}
		catch(DateTimeParseException e) {
			throw new InvalidDateFormatException("Invalid date format in row " + row.getRowNum() );
		}
						
	}


	@Valid
	public void saveMedicine(Medicine medicine) {

		medicineRepository.save(medicine);

	}

	public List<MedicineResponse> findMedicineByNameOrIngredients(String text) {
		
		 text = "%"+text+"%";
		 List<Medicine> medicines=medicineRepository.findByNameLikeIgnoreCaseOrIngredientsLikeIgnoreCase(text, text);
		 if(medicines.isEmpty())
			 throw new NoMedicinesFoundException("No medicine found");
		 else
			 
		return medicines.stream()
				.map(medicineMapper :: mapToMedicineResponse)
				.toList();
	}

	
	}


	



	
	

	

