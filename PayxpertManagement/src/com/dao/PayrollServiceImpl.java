package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.dto.Employee;
import com.dto.Payroll;
import com.myexceptions.PayrollGenerationException;

public class PayrollServiceImpl implements IPayrollService {
	
	
	Connection myConnectionObj;
	
	
	

	
	
	

	public PayrollServiceImpl(Connection myConnectionObj) {
		super();
		this.myConnectionObj = myConnectionObj;
		
	}






	@Override
	public void generatePayroll(Payroll payroll) throws SQLException {
		
		PreparedStatement p = this.myConnectionObj.prepareStatement("SELECT employeeid from employee where employeeid = ?");
		p.setInt(1, payroll.getEmployeeID());
		ResultSet r = p.executeQuery();
		
		if(r.next())
		{
			PreparedStatement myStatement = this.myConnectionObj.prepareStatement("INSERT INTO payroll VALUES (?,?,?,?,?,?,?,?)");
			// TODO Auto-generated method stub
			
			myStatement.setInt(1, payroll.getPayrollID());
			myStatement.setInt(2, payroll.getEmployeeID());
			myStatement.setDate(3,new java.sql.Date(payroll.getPayPeriodStartDate().getTime()));
			myStatement.setDate(4, new java.sql.Date(payroll.getPayPeriodEndDate().getTime()));
			myStatement.setDouble(5, payroll.getBasicSalary());
			myStatement.setDouble(6, payroll.getOvertimePay());
			myStatement.setDouble(7, payroll.getDeductions());
			myStatement.setDouble(8, payroll.getNetSalary());
			
			int rowsAffected = myStatement.executeUpdate();
			boolean status = rowsAffected > 0 ? true : false;
			
			if(status)
			{
				System.out.println("Insertation Status is : "+ status);
			}
			else
			{
				System.out.println("Insertation Status is : "+ status);
			}
			
			
		}
		else
		{
			throw new SQLException("Employee Id not found in Employee");
		}
		
		
		
		
		
		
		
	}






	@Override
	public Payroll getPayrollById(int payrollID) throws PayrollGenerationException, SQLException {
		// TODO Auto-generated method stub
		
		 
	     int employeeID;
		 Date payPeriodStartDate;
	     Date payPeriodEndDate;
	     double basicSalary;
	     double overtimePay;
	     double deductions;
	     double netSalary;
		
		Payroll payroll ;
		String query = "SELECT * from payroll WHERE payrollid = ?";
		PreparedStatement myStatement = this.myConnectionObj.prepareStatement(query);
		myStatement.setInt(1, payrollID);
		
		ResultSet state = myStatement.executeQuery();
		
		if(state.next())
		{
			employeeID = state.getInt(2);
			payPeriodStartDate = state.getDate(3);
			payPeriodEndDate = state.getDate(4);
			basicSalary = state.getDouble(5);
			overtimePay = state.getDouble(6);
			deductions = state.getDouble(7);
			netSalary = state.getDouble(8);
			
			payroll = new Payroll(payrollID,employeeID,payPeriodStartDate,payPeriodEndDate,basicSalary,overtimePay,deductions,netSalary);
			
			
		}
		else {
			throw new SQLException("Data Not found of this payroll ID ");
		}
		
		
		return payroll;
	}






	@Override
	public List<Payroll> getPayrollsForEmployee(int employeeID) throws PayrollGenerationException, SQLException {
		// TODO Auto-generated method stub
		int payrollId;
		int employeeId;
		 Date payPeriodStartDate;
	     Date payPeriodEndDate;
	     double basicSalary;
	     double overtimePay;
	     double deductions;
	     double netSalary;
		
		List<Payroll> payrollList = new ArrayList();
		
		String query = "SELECT * from payroll WHERE employeeid = ?";
		PreparedStatement myStatement = this.myConnectionObj.prepareStatement(query);
		myStatement.setInt(1, employeeID);
		ResultSet state = myStatement.executeQuery();
		while(state.next())
		{
			payrollId = state.getInt(1);
			employeeId = state.getInt(2);
			payPeriodStartDate = state.getDate(3);
			payPeriodEndDate = state.getDate(4);
			basicSalary = state.getDouble(5);
			overtimePay = state.getDouble(6);
			deductions = state.getDouble(7);
			netSalary = state.getDouble(8);
			
			payrollList.add(new Payroll (payrollId,employeeId,payPeriodStartDate,payPeriodEndDate,basicSalary,overtimePay,deductions,netSalary));
			
		}
		
		
		
		return payrollList;
	}






	@Override
	public List<Payroll> getPayrollsForPeriod(Date startDate, Date endDate) throws SQLException {
		
		List<Payroll> payList = new ArrayList();
		
		int payrollId;
		int employeeId;
		 Date payPeriodStartDate;
	     Date payPeriodEndDate;
	     double basicSalary;
	     double overtimePay;
	     double deductions;
	     double netSalary;
		
		String query = "SELECT * FROM payroll WHERE payPeriodStartDate = ? and payPeriodEndDate = ?" ;
		PreparedStatement myStatement = this.myConnectionObj.prepareStatement(query);
		myStatement.setDate(1,new java.sql.Date(startDate.getTime()));
		myStatement.setDate(2,new java.sql.Date(endDate.getTime()));
		ResultSet state = myStatement.executeQuery();
		
		while(state.next())
		{
			payrollId = state.getInt(1);
			employeeId = state.getInt(2);
			payPeriodStartDate = state.getDate(3);
			payPeriodEndDate = state.getDate(4);
			basicSalary = state.getDouble(5);
			overtimePay = state.getDouble(6);
			deductions = state.getDouble(7);
			netSalary = state.getDouble(8);
			
			payList.add(new Payroll (payrollId,employeeId,payPeriodStartDate,payPeriodEndDate,basicSalary,overtimePay,deductions,netSalary));
			
			
		}
		
		
		
		
		// TODO Auto-generated method stub
		return payList;
	}
	
	
		
	

}
