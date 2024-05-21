package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dto.Employee;
import com.dto.FinancialRecord;
import com.myexceptions.FinancialRecordException;

public class FinancialRecordServiceImpl implements IFinancialRecordService {
	
	Connection myConnectionObj;
	
	
	
	public FinancialRecordServiceImpl(Connection myConnectionObj) {
		super();
		this.myConnectionObj = myConnectionObj;
	}

	@Override
	public void addFinancialRecord(FinancialRecord financialRecord) throws FinancialRecordException, SQLException {
		// TODO Auto-generated method stub
		
		String query = "INSERT INTO financialrecord VALUES (?,?,?,?,?,?)";
		PreparedStatement myStatement = this.myConnectionObj.prepareStatement(query);
		myStatement.setInt(1, financialRecord.getRecordID());
		myStatement.setInt(2,financialRecord.getEmployeeID());
		myStatement.setDate(3, new java.sql.Date(financialRecord.getRecordDate().getTime()));
		myStatement.setString(4, financialRecord.getDescription());
		myStatement.setDouble(5, financialRecord.getAmount());
		myStatement.setString(6, financialRecord.getRecordType());
		
		int rowsAffected = myStatement.executeUpdate();
		boolean status = rowsAffected>0 ? true : false;
		
		if(status)
		{
			System.out.println("Insertation Status is : "+ status);
		}
		else
		{
			System.out.println("Insertation Status is : "+ status);
		}
		
	}

	@Override
	public FinancialRecord getFinancialRecordById(int recordID) throws FinancialRecordException, SQLException {
		// TODO Auto-generated method stub
		
		FinancialRecord financialRecord = null ;
		int recordId;
	     int employeeId;
	     Date recordDate; 
		 String description;
	     double amount;
	     String recordType;
	     
	     
	     String query = "SELECT * FROM financialrecord WHERE recordid = ?";
	     PreparedStatement myStatement = this.myConnectionObj.prepareStatement(query);
	     myStatement.setInt(1, recordID);
	     ResultSet r= myStatement.executeQuery();
	     if(r.next())
	     {
	    	 recordId = r.getInt(1);
	    	 employeeId = r.getInt(2);
	    	 recordDate = r.getDate(3);
	    	 description = r.getString(4);
	    	 amount = r.getDouble(5);
	    	 recordType = r.getString(6);
	    	 
	    	 financialRecord = new FinancialRecord(recordId,employeeId,recordDate,description,amount,recordType);
	    	 
	     }
	     
		
		return financialRecord;
	}

	@Override
	public List<FinancialRecord> getFinancialRecordsForEmployee(int employeeID) throws FinancialRecordException, SQLException {
		// TODO Auto-generated method stub
		
		List<FinancialRecord> financeList = new ArrayList();
		
		int recordId;
	     int employeeId;
	     Date recordDate; 
		 String description;
	     double amount;
	     String recordType;
	     
		String query = "SELECT * FROM financialrecord WHERE employeeid = ?";
	     PreparedStatement myStatement = this.myConnectionObj.prepareStatement(query);
	     myStatement.setInt(1, employeeID);
	     ResultSet r= myStatement.executeQuery();
	     while(r.next())
	     {
	    	 recordId = r.getInt(1);
	    	 employeeId = r.getInt(2);
	    	 recordDate = r.getDate(3);
	    	 description = r.getString(4);
	    	 amount = r.getDouble(5);
	    	 recordType = r.getString(6);
	    	 
	    	 financeList.add(new FinancialRecord(recordId,employeeId,recordDate,description,amount,recordType));
	    	 
	     }
		
		
		
		
		return financeList;
	}

	@Override
	public List<FinancialRecord> getFinancialRecordsForDate(Date date) throws SQLException {
		// TODO Auto-generated method stub
		
		
		List<FinancialRecord> financeList = new ArrayList();
		int recordId;
	     int employeeId;
	     Date recordDate; 
		 String description;
	     double amount;
	     String recordType;
	     
	     String query = "SELECT * FROM financialrecord WHERE recorddate = ?";
	     PreparedStatement myStatement = this.myConnectionObj.prepareStatement(query);
	     myStatement.setDate(1, new java.sql.Date(date.getTime()));
	     ResultSet r= myStatement.executeQuery();
	     while(r.next())
	     {
	    	 recordId = r.getInt(1);
	    	 employeeId = r.getInt(2);
	    	 recordDate = r.getDate(3);
	    	 description = r.getString(4);
	    	 amount = r.getDouble(5);
	    	 recordType = r.getString(6);
	    	 
	    	 financeList.add(new FinancialRecord(recordId,employeeId,recordDate,description,amount,recordType));
	    	 
	     }
		
		
		return financeList;
	}
	

	

}


