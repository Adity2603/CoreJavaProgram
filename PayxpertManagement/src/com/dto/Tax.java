package com.dto;



public class Tax {
    public Tax() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int taxID;
    private int employeeID;
    private int taxYear;
    private double taxableIncome;
    private double taxAmount;
	public Tax(int taxID, int employeeID, int taxYear, double taxableIncome, double taxAmount) {
		super();
		this.taxID = taxID;
		this.employeeID = employeeID;
		this.taxYear = taxYear;
		this.taxableIncome = taxableIncome;
		this.taxAmount = taxAmount;
	}
	public int getTaxID() {
		return taxID;
	}
	public void setTaxID(int taxID) {
		this.taxID = taxID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}
	public double getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	@Override
	public String toString() {
		return "************************************************\n"+
				"taxID = " + taxID +"\n\n"+
				"employeeID = " + employeeID + "\n\n"+
				"taxYear = " + taxYear +"\n\n"+
				"taxableIncome = "+ taxableIncome + "\n\n"+
				"taxAmount = " + taxAmount+"\n\n"+
				"************************************************\n";
	}

    // Constructors, Getters, and Setters (omitted for brevity)
}
