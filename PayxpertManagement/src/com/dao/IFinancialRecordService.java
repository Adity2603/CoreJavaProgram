package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.dto.FinancialRecord;
import com.myexceptions.FinancialRecordException;

public interface IFinancialRecordService {
    void addFinancialRecord(FinancialRecord financialRecord) throws FinancialRecordException, SQLException;
    FinancialRecord getFinancialRecordById(int recordID) throws FinancialRecordException, SQLException;
    List<FinancialRecord> getFinancialRecordsForEmployee(int employeeID) throws FinancialRecordException, SQLException;
    List<FinancialRecord> getFinancialRecordsForDate(Date date) throws SQLException;
}
