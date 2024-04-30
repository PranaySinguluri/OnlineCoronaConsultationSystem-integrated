package com.coronaconsultation.exception;

public class MedicalReportNotFoundException extends RuntimeException {

	String message ="not found";
public MedicalReportNotFoundException(String message) {
	super(message);
}
}
