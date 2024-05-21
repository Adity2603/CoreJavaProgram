package com.myexceptions;

public class EmployeeNotFoundException extends Exception {

	public EmployeeNotFoundException(String message) {
		super(message + "Employee Not Found");
		// TODO Auto-generated constructor stub
	}
	
	

}
