package com.coronaconsultation.exception;

public class PatientReportNotFoundException extends RuntimeException {
	public PatientReportNotFoundException(String message) {
		super(message);
	}
}
