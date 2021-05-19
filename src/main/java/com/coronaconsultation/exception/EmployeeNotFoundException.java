package com.coronaconsultation.exception;

import java.sql.SQLException;

public class EmployeeNotFoundException  extends RuntimeException{
	public EmployeeNotFoundException(String message) {
		super(message);	
	}
	

}
