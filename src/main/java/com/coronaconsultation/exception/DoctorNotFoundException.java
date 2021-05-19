package com.coronaconsultation.exception;

import java.sql.SQLException;

public class DoctorNotFoundException extends RuntimeException {
	public DoctorNotFoundException(String message) {
		super(message);
	}
}
