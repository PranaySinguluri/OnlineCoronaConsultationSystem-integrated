package com.coronaconsultation.services;

import java.awt.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.coronaconsultation.entities.Medicine;
import com.coronaconsultation.exception.MedicineIdNotFoundException;
@Component
@Service
public interface IMedicineMaster {

	public Medicine saveMed(Medicine med);
	public List  getAllMeds();
	public Medicine updateMed(Medicine med);
	public Optional<Medicine> getMedicineById(int medicineId) throws MedicineIdNotFoundException ;
	public void deleteMed(int id);
	
}
