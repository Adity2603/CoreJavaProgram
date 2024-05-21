package com.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.Employee;
import com.dto.Tax;
import com.myexceptions.TaxCalculationException;

public class TaxServiceImpl implements ITaxService {
	
	Connection myConnectionObj ;
	
	
 
	public TaxServiceImpl(Connection myConnectionObj) {
		super();
		this.myConnectionObj = myConnectionObj;
	}
	


	@Override
	public double calculateTax(int employeeID, int taxYear) throws SQLException {
		
		// TODO Auto-generated method stub
		
		
		double totalIncome;
		double tax = 0.0;
		String query = "SELECT netSalary , deductions FROM payroll where employeeid = ?";
		PreparedStatement myStatement = this.myConnectionObj.prepareStatement(query);
		myStatement.setInt(1, employeeID);
		ResultSet r = myStatement.executeQuery();
		if(r.next())
		{
			totalIncome = r.getDouble("netSalary") + r.getDouble("deductions");
			
		    double taxRate1 = 0.10; 
		    double taxRate2 = 0.20; 
		    double taxRate3 = 0.30;
		    if (totalIncome <= 10000) {
		        tax = totalIncome * taxRate1;
		    } else if (totalIncome <= 50000) {
		        tax = 10000 * taxRate1 + (totalIncome - 10000) * taxRate2;
		    } else {
		        tax = 10000 * taxRate1 + 40000 * taxRate2 + (totalIncome - 50000) * taxRate3;
		    }
		    return tax;
		}
		else
		{
			System.out.println("Employee Not Found");
			return tax;
		}
		
		
		
		
		
		
	}

	@Override
	public Tax getTaxById(int taxId) throws TaxCalculationException, SQLException {
		// TODO Auto-generated method stub
		
		Tax tax = null;
		 int taxID;
	     int employeeID;
	     int taxYear;
	     double taxableIncome;
	     double taxAmount;
		
		String query = "SELECT * FROM tax WHERE taxid = ?";
		PreparedStatement myStatement = this.myConnectionObj.prepareStatement(query);
		myStatement.setInt(1, taxId);
		ResultSet r = myStatement.executeQuery();
		if(r.next())
		{
			taxID = r.getInt(1);
			employeeID = r.getInt(2);
			taxYear = r.getInt(3);
			taxableIncome = r.getDouble(4);
			taxAmount = r.getDouble(5);
			
			tax = new Tax( taxID,  employeeID,  taxYear,  taxableIncome,  taxAmount);
				
		}
		else
		{
			throw new SQLException("Tax id Not found");
		}
		
		
		
		return tax;
	}

	@Override
	public List<Tax> getTaxesForEmployee(int employeeID) throws SQLException {
		// TODO Auto-generated method stub
		
		List<Tax> taxList = new ArrayList();
		int taxID;
	     int employeeId;
	     int taxYear;
	     double taxableIncome;
	     double taxAmount;
	     
	     String query = "SELECT * FROM tax WHERE employeeid = ?";
			PreparedStatement myStatement = this.myConnectionObj.prepareStatement(query);
			myStatement.setInt(1, employeeID);
			ResultSet r = myStatement.executeQuery();
			if(r.next())
			{
				taxID = r.getInt(1);
				employeeId = r.getInt(2);
				taxYear = r.getInt(3);
				taxableIncome = r.getDouble(4);
				taxAmount = r.getDouble(5);
				
				taxList.add(new Tax( taxID,  employeeID,  taxYear,  taxableIncome,  taxAmount));
				
			}
			else
			{
				throw new SQLException("Tax recored not found of this Employee Id ");
			}
		
		
		
		
			return taxList;
	}

	@Override
	public List<Tax> getTaxesForYear(int year) throws SQLException {
		// TODO Auto-generated method stub
		
		List<Tax> taxList = new ArrayList();
		int taxID;
	     int employeeId;
	     int taxYear;
	     double taxableIncome;
	     double taxAmount;
	     
	     String query = "SELECT * FROM tax WHERE taxyear = ?";
			PreparedStatement myStatement = this.myConnectionObj.prepareStatement(query);
			myStatement.setInt(1, year);
			ResultSet r = myStatement.executeQuery();
			while(r.next())
			{
				taxID = r.getInt(1);
				employeeId = r.getInt(2);
				taxYear = r.getInt(3);
				taxableIncome = r.getDouble(4);
				taxAmount = r.getDouble(5);
				
				taxList.add(new Tax( taxID,  employeeId,  taxYear,  taxableIncome,  taxAmount));
				
			}
		
		return taxList;
	}



	@Override
	public void addTaxRecord(Tax tax) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement st = this.myConnectionObj.prepareStatement("INSERT INTO tax VALUES (?,?,?,?,?)");
		st.setInt(1, tax.getTaxID());
		st.setInt(2, tax.getEmployeeID());
		st.setInt(3, tax.getTaxYear());
		st.setDouble(4, tax.getTaxableIncome());
		st.setDouble(5, tax.getTaxAmount());
		int rowsAffected = st.executeUpdate();
		boolean status = rowsAffected>0 ? true :false ;
		if(status)
		{
			System.out.print("Insertion Status : "+status);
		}
		else
		{
			System.out.print("Insertion Status : "+status);
		}
	}

	
	
	




	

}
