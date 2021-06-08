package com.coronaconsultation.services;

import java.awt.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.Medicine;
import com.coronaconsultation.exception.MedicineIdNotFoundException;
import com.coronaconsultation.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements IMedicineMaster{
	private static final String ERROR_MESSAGE = "Patient ID Not Found";
	@Autowired
	private MedicineRepository repo;

	@Override
	public Medicine saveMed(Medicine med) {
		return repo.save(med);
	}

	@Override
	public Medicine updateMed(Medicine med) {
		return repo.save(med);
	}

	@Override
	public Optional<Medicine> getMedicineById(int id) throws  MedicineIdNotFoundException{
       try {
    	   return repo.findById(id);
       }
       catch (Exception e) {
    	   throw new  MedicineIdNotFoundException(id);
       }
		
	}
	@Override
	public void deleteMed(int id) {

		repo.deleteById(id);
		
	}
	@Override
	public List getAllMeds() {
		return null;
	}

	

	
}