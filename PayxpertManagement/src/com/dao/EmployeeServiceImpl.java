package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.Employee;
import com.myexceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl implements IEmployeeService {

	
	Connection myConnectionObj;
	
	
	
	
public EmployeeServiceImpl(Connection myConnectionObj) {
		super();
		this.myConnectionObj = myConnectionObj;
	}



//	TO FIND THE EMPLOYEE

	@Override
	public Employee getEmployeeById(int employeeID) throws SQLException {
		
		Employee employee;
		int id = 0;
		String firstName = null, lastName = null,  gender = null,email = null,phoneNumber = null,address = null,position = null;
		Date dateOfBirth = null,joiningDate = null,terminationDate = null;
		PreparedStatement myStatement = this.myConnectionObj.prepareStatement("SELECT * FROM employee WHERE employeeid = ?");
		myStatement.setInt(1, employeeID);
		ResultSet state = myStatement.executeQuery();
		if(state.next())
		{
			  id = state.getInt(1);
		      firstName=state.getString(2);
		      lastName=state.getString(3);
		      dateOfBirth=state.getDate(4);
		      gender=state.getString(5);
		      email=state.getString(6);
		      phoneNumber=state.getString(7);
		      address=state.getString(8);
		      position=state.getString(9);
		      joiningDate=state.getDate(10);
		      terminationDate=state.getDate(11);
		}
		
		employee = new Employee(id,firstName, lastName, dateOfBirth, gender,email,phoneNumber,address,position,joiningDate,terminationDate );

		
		return employee;
	}

	
	

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		
		List<Employee> empList = new ArrayList();
		
		int id = 0;
		String firstName = null, lastName = null,  gender = null,email = null,phoneNumber = null,address = null,position = null;
		Date dateOfBirth = null;
		Date joiningDate = null,terminationDate = null;
		PreparedStatement myStatement = this.myConnectionObj.prepareStatement("SELECT * FROM employee");
		
		ResultSet state = myStatement.executeQuery();
		while(state.next())
		{
			  id = state.getInt(1);
		      firstName=state.getString(2);
		      lastName=state.getString(3);
		      dateOfBirth=state.getDate(4);
		      gender=state.getString(5);
		      email=state.getString(6);
		      phoneNumber=state.getString(7);
		      address=state.getString(8);
		      position=state.getString(9);
		      joiningDate=state.getDate(10);
		      terminationDate=state.getDate(11);
		      empList.add(new Employee(id,firstName, lastName, dateOfBirth, gender,email,phoneNumber,address,position,joiningDate,terminationDate ));
		}
		
		
		return empList;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
	
		
		PreparedStatement myStatement = this.myConnectionObj.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?)");
		myStatement.setInt(1, employee.getEmployeeID());
		myStatement.setString(2, employee.getFirstName());
		myStatement.setString(3, employee.getLastName());
		myStatement.setDate(4,new java.sql.Date(employee.getDateOfBirth().getTime())); // yyyy-mm-dd
		myStatement.setString(5, employee.getGender());
		myStatement.setString(6, employee.getEmail());
		myStatement.setString(7, employee.getPhoneNumber());
		myStatement.setString(8, employee.getAddress());
		myStatement.setString(9, employee.getPosition());
		myStatement.setDate(10,new java.sql.Date (employee.getJoiningDate().getTime()));
		myStatement.setDate(11, null);
		
		int rowsAffected = myStatement.executeUpdate();
		boolean status = rowsAffected > 0 ? true : false;
		if(status)
		{
			System.out.println("\nInsertation Status is : "+ status);
		}
		else
		{
			System.out.println("\nInsertation Status is : "+ status);
		}
		
		
	}

	@Override
	public void updateEmployee(Employee employee) throws SQLException {
		
		
		
    		PreparedStatement myStatement = this.myConnectionObj.prepareStatement("UPDATE employee SET firstName = ?, lastName = ?, dateOfBirth = ?, gender = ?, " +
                    "email = ?, phoneNumber = ?, address = ?, position = ?, joiningDate = ?, " +
                    "terminationDate = ? WHERE employeeid = ?");
    		
    		myStatement.setString(1, employee.getFirstName());
    		myStatement.setString(2, employee.getLastName());
    		myStatement.setDate(3,new java.sql.Date(employee.getDateOfBirth().getTime()));
    		myStatement.setString(4, employee.getGender());
    		myStatement.setString(5, employee.getEmail());
    		myStatement.setString(6, employee.getPhoneNumber());
    		myStatement.setString(7, employee.getAddress());
    		myStatement.setString(8, employee.getPosition());
    		myStatement.setDate(9,new java.sql.Date (employee.getJoiningDate().getTime()));
    		if (employee.getTerminationDate() != null) {
    	        myStatement.setDate(10, new java.sql.Date(employee.getTerminationDate().getTime()));
    	    } else {
    	        myStatement.setNull(10, java.sql.Types.DATE);
    	    }
    		myStatement.setInt(11, employee.getEmployeeID());
    		
    		int rowsAffected = myStatement.executeUpdate();
    		boolean status = rowsAffected > 0 ;
    		System.out.println("Updation Status is : "+ status);
    		
    				
		
	}

	@Override
	public boolean removeEmployee(int employeeID) throws SQLException {
		
		boolean removeStatus=false;
		 PreparedStatement myStatement=this.myConnectionObj.prepareStatement("DELETE FROM employee WHERE employeeid=?");
		 myStatement.setInt(1, employeeID);
		 int rowsAffected = myStatement.executeUpdate();
		 removeStatus = rowsAffected > 0 ? true : false;
//		 
		return removeStatus;
		
		
	}

}
