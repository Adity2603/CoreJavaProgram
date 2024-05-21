package com.testing;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.dao.PayrollServiceImpl;
import com.dbconnection.ConnectionFactory;
import com.dto.Payroll;

public class PayrollServiceTest {
	
	 @Test
	    void processPayrollForEmployee() {
		 Connection myConnectionObj = ConnectionFactory.getConnection();
		 
	        PayrollServiceImpl payrollService = new PayrollServiceImpl(myConnectionObj);
	        int payrollId = 103;
	        int employeeId = 3; 
	        Date startDate = new Date(); 
	        Date endDate = new Date();
	        double basicSalary = 5000.0; 
	        double overtimePay = 1000.0;
	        double deductions = 500.0;
	        double netSalary = basicSalary + overtimePay - deductions;

	        Payroll payroll = new Payroll(payrollId, employeeId, startDate, endDate, basicSalary, overtimePay, deductions, netSalary);
	        assertNotNull(payroll);
	        try {
	            payrollService.generatePayroll(payroll);
	            
	        } catch (Exception e ) {
	            fail("Exception occurred: "+ e.getMessage());
	        }
	    }

}
