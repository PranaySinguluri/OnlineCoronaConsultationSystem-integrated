package com.coronaconsultation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="Medicine Id not found")
public class MedicineIdNotFoundException extends Exception {
	String message="Medicine ID not found";

	private static final int serialVersionUID = 1;
	
	public MedicineIdNotFoundException(String message) {
		super(message);
	}

	public MedicineIdNotFoundException(int id) {
		
		message=id+"ID NOT FOUND";
	}
	
}
