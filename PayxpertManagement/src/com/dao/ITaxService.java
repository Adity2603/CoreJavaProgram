package com.dao;



import java.sql.SQLException;
import java.util.List;

import com.dto.Tax;
import com.myexceptions.TaxCalculationException;

public interface ITaxService {
	 void addTaxRecord(Tax tax) throws SQLException;
    double calculateTax(int employeeID, int taxYear) throws SQLException;
    Tax getTaxById(int taxId) throws TaxCalculationException, SQLException;
    List<Tax> getTaxesForEmployee(int employeeID) throws SQLException;
    List<Tax> getTaxesForYear(int year) throws SQLException;
}
