package com.dao;



import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.dto.Payroll;
import com.myexceptions.PayrollGenerationException;

public interface IPayrollService {
    
    Payroll getPayrollById(int payrollID) throws PayrollGenerationException, SQLException;
    List<Payroll> getPayrollsForEmployee(int employeeID) throws PayrollGenerationException, SQLException;
    List<Payroll> getPayrollsForPeriod(Date startDate, Date endDate) throws SQLException;
	void generatePayroll(Payroll payroll) throws SQLException;
}
