package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.dao.TaxServiceImpl;
import com.dbconnection.ConnectionFactory;

public class TaxServiceTest {

	@Test
    void verifyTaxCalculationForHighIncomeEmployee() {
		
		Connection myConnectionObj = ConnectionFactory.getConnection();
	 TaxServiceImpl taxService = new TaxServiceImpl(myConnectionObj);
     int employeeId = 1; 
     int taxYear = 2024; 

     
     try {
         double tax = taxService.calculateTax(employeeId, taxYear);
         System.out.println(tax);
         double expectedValue = 12000.0; 
         assertEquals(expectedValue, tax, 0.01); 
     }
     catch(Exception e) {
    	 fail("Exception occurred: " + e.getMessage()); 
     }
     
 }

	
}
