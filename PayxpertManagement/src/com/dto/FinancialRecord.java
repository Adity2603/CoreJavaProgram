package com.dto;


import java.util.Date;

public class FinancialRecord {
    
	private int recordID;
    private int employeeID;
    private Date recordDate; 
	private String description;
    private double amount;
    private String recordType;
   
    
    
    


	public FinancialRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    public FinancialRecord(int recordID, int employeeID, Date recordDate, String description, double amount,
			String recordType) {
		super();
		this.recordID = recordID;
		this.employeeID = employeeID;
		this.recordDate = recordDate;
		this.description = description;
		this.amount = amount;
		this.recordType = recordType;
	}


	public int getRecordID() {
		return recordID;
	}


	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}


	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public Date getRecordDate() {
		return recordDate;
	}


	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getRecordType() {
		return recordType;
	}


	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
    
	@Override
	public String toString() {
		return "****************************************************\n"+
				"recordID = " + recordID + "\n\n"+
				"employeeID = " + employeeID +"\n\n"+
				"recordDate = " + recordDate+"\n\n"+
				"description = " + description + "\n\n"+
				"amount = " + amount + "\n\n"+
				"recordType = " + recordType + "\n\n"+
				"****************************************************\n";
	}
    // Constructors, Getters, and Setters (omitted for brevity)
}
