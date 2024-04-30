package com.coronaconsultation.exception;

import java.sql.SQLException;

public class EmployeeNotFoundException  extends RuntimeException{

	String message =" No Employee Found";
	public EmployeeNotFoundException(String message) {
		super(message);	
	}
}
