package com.coronaconsultation.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Report Id not Found")
public class MedicineReportIdNotFoundException extends RuntimeException {
	String message="Medicine ID not found";


	private static final long serialVersionUID = 1L;
	
	public MedicineReportIdNotFoundException(String message) {
		super(message);
	}
	public MedicineReportIdNotFoundException(int id) {
		
		message=id+"ID NOT FOUND";
	}
}