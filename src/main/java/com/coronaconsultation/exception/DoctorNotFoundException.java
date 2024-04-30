package com.coronaconsultation.exception;

import java.sql.SQLException;

public class DoctorNotFoundException extends RuntimeException {
	String message = " No doctor found";
	public DoctorNotFoundException(String message) {
		super(message);
	}
}
