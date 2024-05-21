package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dto.Payroll;

public class PayrollTest {
	
	@Test
	void CalcutateNetSalaryAfterDeduction() {
		
		Payroll p1 = new Payroll();
		p1.setBasicSalary(1000.0);
		p1.setDeductions(100.0);
		p1.setOvertimePay(300.0);
		p1.setNetSalary(1200.0);
		
		double actualNetSalary = p1.getBasicSalary()-p1.getDeductions()+p1.getOvertimePay();
		assertEquals(p1.getNetSalary(),actualNetSalary);
		
	}
	
	@Test
	 void CalculateGrossSalaryForEmployee()
	 {
		double basic = 1000;
		double deduction = 100;
		double overtime = 200;
		double gross = basic + deduction + overtime;
		Payroll p = new Payroll();
		p.setBasicSalary(1000);
		p.setDeductions(100);
		p.setOvertimePay(200);
		
		double grossSalary = p.getBasicSalary() + p.getDeductions() + p.getOvertimePay();
		assertEquals(gross,grossSalary);
	 }

}
