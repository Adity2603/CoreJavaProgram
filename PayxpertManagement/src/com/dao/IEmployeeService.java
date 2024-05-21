package com.dao;



import java.sql.SQLException;
import java.util.List;

import com.dto.Employee;
import com.myexceptions.EmployeeNotFoundException;

public interface IEmployeeService {
    Employee getEmployeeById(int employeeID) throws  SQLException;
    List<Employee> getAllEmployees() throws SQLException;
    void addEmployee(Employee employee) throws SQLException;
    void updateEmployee(Employee employee) throws  SQLException, EmployeeNotFoundException;
    boolean removeEmployee(int employeeID) throws SQLException;
}
