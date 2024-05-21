package com.testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.dbconnection.ConnectionFactory;
import com.dto.Employee;
import com.dao.EmployeeServiceImpl;

public class EmployeeServiceTest {

    @Test
    void verifyErrorHandlingForInvalidEmployeeData() throws ParseException {
        Connection myConnectionObj = ConnectionFactory.getConnection();
        
        int employeeID = 1;
        String firstName = "Aditya";
        String lastName = "Deshmukh";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = sdf.parse("2003-02-26");
        
        String gender = "male";
        String email = "amd@gmail.com";
        String phoneNumber = "9860735312";
        String address = "satara";
        String position = "manager";
        Date joiningDate = sdf.parse("2024-06-01");
        Date terminationDate = null;
        
        Employee testemp = new Employee(employeeID, firstName, lastName, new java.sql.Date(dateOfBirth.getTime()) , gender, email,
                phoneNumber, address, position, new java.sql.Date(joiningDate.getTime()), terminationDate);
        
        EmployeeServiceImpl es = new EmployeeServiceImpl(myConnectionObj);
        
        Employee test2 = null;
        try {
            test2 = es.getEmployeeById(employeeID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Print debug statements
        System.out.println("Expected Employee: " + testemp);
        System.out.println("Actual Employee: " + test2);
        
        // Check if test2 is null
//        assertTrue(test2 != null, "Retrieved employee should not be null");
        
        // Check if both objects are equal
        assertTrue(testemp.equals(test2));
    }
}
