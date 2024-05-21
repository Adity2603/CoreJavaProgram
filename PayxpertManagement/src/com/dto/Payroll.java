package com.dto;


import java.time.LocalDate;
import java.util.Date;

public class Payroll {
    private int payrollID;
    private int employeeID;
	private Date payPeriodStartDate;
    private Date payPeriodEndDate;
    private double basicSalary;
    private double overtimePay;
    private double deductions;
    private double netSalary;
	public Payroll() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payroll(int payrollID, int employeeID, Date payPeriodStartDate, Date payPeriodEndDate,
			double basicSalary, double overtimePay, double deductions, double netSalary) {
		super();
		this.payrollID = payrollID;
		this.employeeID = employeeID;
		this.payPeriodStartDate = payPeriodStartDate;
		this.payPeriodEndDate = payPeriodEndDate;
		this.basicSalary = basicSalary;
		this.overtimePay = overtimePay;
		this.deductions = deductions;
		this.netSalary = netSalary;
	}
	public int getPayrollID() {
		return payrollID;
	}
	public void setPayrollID(int payrollID) {
		this.payrollID = payrollID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public Date getPayPeriodStartDate() {
		return payPeriodStartDate;
	}
	public void setPayPeriodStartDate(Date payPeriodStartDate) {
		this.payPeriodStartDate = payPeriodStartDate;
	}
	public Date getPayPeriodEndDate() {
		return payPeriodEndDate;
	}
	public void setPayPeriodEndDate(Date payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getOvertimePay() {
		return overtimePay;
	}
	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}
	public double getDeductions() {
		return deductions;
	}
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	@Override
	public String toString() {
		return "**************************************************\n\n"+
				"payrollID = " + payrollID + "\n\n"+
				"employeeID = " + employeeID + "\n\n"+
				"payPeriodStartDate = "+ payPeriodStartDate + "\n\n"+
				"payPeriodEndDate = " + payPeriodEndDate + "\n\n"+
				"basicSalary = " + basicSalary +"\n\n"+
				"overtimePay = " + overtimePay +"\n\n"+
				"deductions = " + deductions +"\n\n"+
				"netSalary = " + netSalary +"\n\n"+
				"********************************************************\n";
	}

    
}
