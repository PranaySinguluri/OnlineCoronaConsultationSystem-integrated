package com.coronaconsultation.exception;

import java.sql.SQLException;

public class DoctorReportNotFoundException extends RuntimeException {
	public DoctorReportNotFoundException(String message) {
		super(message);
	}
}
