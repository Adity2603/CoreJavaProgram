package com.mainmod;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dao.EmployeeServiceImpl;
import com.dao.FinancialRecordServiceImpl;
import com.dao.PayrollServiceImpl;
import com.dao.TaxServiceImpl;
import com.dbconnection.ConnectionFactory;
import com.dto.Employee;
import com.dto.FinancialRecord;
import com.dto.Payroll;
import com.dto.Tax;
import com.myexceptions.EmployeeNotFoundException;
import com.myexceptions.FinancialRecordException;
import com.myexceptions.PayrollGenerationException;

public class MainMod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
//		 EMPLOYEE ENTITY VARIABLES
		
		 int employeeID ;
		 String firstName;
	     String lastName;
	     Date dateOfBirth = null;
	     String gender;
	     String email;
	     String phoneNumber;
	     String address;
	     String position;
	     Date joiningDate = null;
	     Date terminationDate = null;
	     
	     
//	     PAYROLL ENTITY VARIABLES 
	     
	      int payrollID;
	 	 Date payPeriodStartDate = null;
	      Date payPeriodEndDate = null;
	      double basicSalary;
	      double overtimePay;
	      double deductions;
	      double netSalary;
	      
	      
//	      TAX ENTITY VARIABLES
	      
	       int taxID;
	       int taxYear;
	       double taxableIncome;
	       double taxAmount;
	       
	     
//	     FINANCIAL ENTITY VARIABLES
	       
	        int recordID;
	        Date recordDate = null; 
	        String description;
	        double amount;
	        String recordType;
	     
		
		
		Scanner sc = new Scanner(System.in);
		int choice;
		Connection myConnectionObj = ConnectionFactory.getConnection();
		
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl(myConnectionObj);
		PayrollServiceImpl payrollService = new PayrollServiceImpl(myConnectionObj);
		TaxServiceImpl taxService = new TaxServiceImpl(myConnectionObj);
		FinancialRecordServiceImpl financeService = new FinancialRecordServiceImpl(myConnectionObj);
		
		
		while(true)
		{
			System.out.println("\n **************  Payroll Management  *********************");
			System.out.println("1. Employee Service");
			System.out.println("2. Payroll Service");
			System.out.println("3. Tax Service");
			System.out.println("4. Financial Service");
			System.out.println("\n Enter Your Choice :- ");
			choice = sc.nextInt();
			
			switch(choice)
			{
			
//		***********************	EMPLOYEE SERVICES ******************************
			
			case 1:
			{
				int subChoice;
				System.out.println("\n **************  Employee Services  ********************* \n ");
				System.out.println("1. Add Employee");
				System.out.println("2. Update Employee");
				System.out.println("3. Remove Employee");
				System.out.println("4. Get Employee by Employee ID");
				System.out.println("5. Get All Employees");
				System.out.println("\n Enter Your Choice :- ");
				subChoice = sc .nextInt();
				switch(subChoice)
				{
				case 1 :
				{
					System.out.println("\n Enter Details of Employee ");
					System.out.println("\n Employee Id  :  ");
					employeeID = sc.nextInt();
					System.out.println("\n First Name  :  ");
					firstName = sc.next();
					System.out.println("\n Last Name  :  ");
					lastName = sc.next();
					System.out.println("\n Date of Birth (YYYY-MM-DD Format)  :  ");
					String dateBirth = sc.next();
					 try {
						dateOfBirth = formatter.parse(dateBirth);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
//					dateOfBirth = parseDate(sc.next());
					System.out.println("\n Gender :  ");
					gender = sc.next();
					System.out.println("\n Email :  ");
					email = sc.next();
					System.out.println("\n Phone Number :  ");
					phoneNumber = sc.next();
					System.out.println("\n Address :  ");
					address = sc.next();
					System.out.println("\n Position :  ");
					position = sc.next();
					System.out.println("\n Joining Date  (YYYY-MM-DD Format) :  ");
					String dateJoin = sc.next();
					try {
					joiningDate	 = formatter.parse(dateJoin);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
//					joiningDate = parseDate(sc.next());
					
					
					try {
						employeeService.addEmployee(new Employee(employeeID , firstName, lastName, dateOfBirth , gender,email,phoneNumber,address,position,joiningDate,null));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					
					
					
					break;
				}
				case 2 :
				{
				
					System.out.println("\n Enter Details of Employee ");
					System.out.println("\n Employee Id  :  ");
					employeeID = sc.nextInt();
					System.out.println("\n First Name  :  ");
					firstName = sc.next();
					System.out.println("\n Last Name  :  ");
					lastName = sc.next();
					System.out.println("\n Date of Birth (YYYY-MM-DD Format)  :  ");
					String dateBirth = sc.next();
					 try {
						dateOfBirth = formatter.parse(dateBirth);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					System.out.println("\n Gender :  ");
					gender = sc.next();
					System.out.println("\n Email :  ");
					email = sc.next();
					System.out.println("\n Phone Number :  ");
					phoneNumber = sc.next();
					System.out.println("\n Address :  ");
					address = sc.next();
					System.out.println("\n Position :  ");
					position = sc.next();
					System.out.println("\n Joining Date  (YYYY-MM-DD Format) :  ");
					String dateJoin = sc.next();
					try {
						joiningDate = formatter.parse(dateJoin);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					System.out.println("\n Do you want to terminate Employee (YES || NO) :  ");
					String check = sc.next();
					if(check.equalsIgnoreCase("NO"))
					{
						try {
							employeeService.updateEmployee(new Employee(employeeID , firstName, lastName, dateOfBirth , gender,email,phoneNumber,address,position,joiningDate,null));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.getMessage();
						} 
					}
					else
					{
						System.out.println("\n Termination Date  (YYYY-MM-DD Format) :  ");
						String dateTerminate = sc.next();
						try {
							terminationDate = formatter.parse(dateTerminate);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						try {
							employeeService.updateEmployee(new Employee(employeeID , firstName, lastName, dateOfBirth , gender,email,phoneNumber,address,position,joiningDate,terminationDate));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					}
					
					
					 
					System.out.println("\n GOING INTO FUNCTION  ");
					
					
					
					System.out.println("\n COMING OUT OF FUNCTION  ");
					
					
					break;
					 
				}
				case 3 :
				{
					System.out.println("\n Employee Id  :  ");
					employeeID = sc.nextInt();
					try {
						System.out.println("Deletion Status is : "+employeeService.removeEmployee(employeeID));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 4 :
				{
					System.out.println("\n Employee Id  :  ");
					employeeID = sc.nextInt();
					try {
						System.out.println(employeeService.getEmployeeById(employeeID));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 5 :
				{
					List<Employee> empList = new ArrayList();
					try {
						empList = employeeService.getAllEmployees();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					for(Employee e : empList)
					{
						System.out.println(e);
					}
					break;
				}
				default :
				{
					System.out.println("Invalid Choice.........");
					break;
				}
				}
				
				break;
			}
			
//			***********************	PAYROLL SERVICES ******************************
			
			
			case 2:
			{
				int payChoice;
				System.out.println("\n **************  PayRoll Services  ********************* \n ");
				System.out.println("1. Generate PayRoll");
				System.out.println("2. Get PayRoll by Employtee Id");
				System.out.println("3. Get  Payroll Payroll Id");
				System.out.println("4. Get All Payroll of Specific Dates");
				
				System.out.println("\n Enter Your Choice :- ");
				
				payChoice = sc.nextInt();
				switch(payChoice)
				{
				case 1 :
				{
					System.out.println("\n Payroll Id (101 starts)  :  ");
					payrollID = sc.nextInt();
					System.out.println("\n Employee Id  :  ");
					employeeID = sc.nextInt();
					System.out.println("\n PayPeriod Start Date  :  ");
					String dateStart = sc.next();
					try {
						payPeriodStartDate = formatter.parse(dateStart);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("\n Pay Period End Date  :  ");
					String dateEnd = sc.next();
					try {
						payPeriodEndDate = formatter.parse(dateEnd);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("\n Basic Salary :  ");
					basicSalary = sc.nextDouble();
					System.out.println("\n Over Time Pay :  ");
					overtimePay = sc.nextDouble();
					System.out.println("\n Deduction  :  ");
					deductions = sc.nextDouble();
					System.out.println("\n Net Salary  :  ");
					netSalary = sc.nextDouble();
					
					try {
						payrollService.generatePayroll(new Payroll(payrollID, employeeID,payPeriodStartDate,payPeriodEndDate,basicSalary,overtimePay,deductions,netSalary));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					
					break;
				}
				case 2 :
				{
					List<Payroll> payList = new ArrayList();
					System.out.println("\n Employee Id  :  ");
					employeeID = sc.nextInt();
					try {
						payList = payrollService.getPayrollsForEmployee(employeeID);
					} catch (PayrollGenerationException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					
					for(Payroll p : payList)
					{
						System.out.println(p);
					}
					
					break;
				}
				case 3 :
				{
					System.out.println("\n Payroll Id (101 starts)  :  ");
					payrollID = sc.nextInt();
					try {
						System.out.println(payrollService.getPayrollById(payrollID));
					} catch (PayrollGenerationException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					break;
				}
				case 4 :
				{
					List<Payroll> payList = new ArrayList();
					System.out.println("\n PayPeriod Start Date  :  ");
					String dateStart = sc.next();
					
					try {
						payPeriodStartDate = formatter.parse(dateStart);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("\n Pay Period End Date  :  ");
					String dateEnd = sc.next();
					try {
						payPeriodEndDate = formatter.parse(dateEnd);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						payList = payrollService.getPayrollsForPeriod(payPeriodStartDate, payPeriodEndDate);
						for(Payroll p : payList)
						{
							System.out.println(p);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				}
				default :
				{
					
					System.out.println("Invalid Choice...........");
					break;
				}
				}
				
				break;
			}
			
//			***********************	TAX SERVICES ******************************
			case 3:
			{
				
				int taxChoice;
				System.out.println("\n **************  Tax Services  ********************* \n ");
				System.out.println("1. Add Tax Record");
				System.out.println("2. Calculate Tax");
				System.out.println("3. Get Tax of Employee by Id");
				System.out.println("4. Get all taxes of a Year");
				
				System.out.println("\n Enter Your Choice :- ");
				taxChoice = sc.nextInt();
				
				switch(taxChoice)
				{
				case 1 :
				{
					System.out.println("\n Tax Id (201 starts)  :  ");
					taxID = sc.nextInt();
					System.out.println("\n Employee Id  :  ");
					employeeID = sc.nextInt();
					System.out.println("\n Tax Year   :  ");
					taxYear = sc.nextInt();
					System.out.println("\n Taxable Income  :  ");
					taxableIncome = sc.nextDouble();
					System.out.println("\n Tax Amount  :  ");
					taxAmount = sc.nextDouble();
					
					try {
						taxService.addTaxRecord(new Tax(taxID,employeeID,taxYear,taxableIncome,taxAmount));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					break;
				}
				case 2 :
				{
					System.out.println("\n Employee Id  :  ");
					employeeID = sc.nextInt();
					System.out.println("\n Tax Year   :  ");
					taxYear = sc.nextInt();
					
					try {
						double tax = taxService.calculateTax(employeeID, taxYear);
						
						System.out.println("Calculated tax is : " + tax);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();;
					}
					
					break;
				}
				case 3 :
				{
					List<Tax> taxList = new ArrayList();
					System.out.println("\n Employee Id  :  ");
					employeeID = sc.nextInt();
					try {
						taxList = taxService.getTaxesForEmployee(employeeID);
						for(Tax t : taxList)
						{
							System.out.println(t);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					
					
							
					break;
				}
				case 4 :
				{
					List<Tax> taxList = new ArrayList();
					System.out.println("\n Tax Year   :  ");
					taxYear = sc.nextInt();
					try {
						taxList = taxService.getTaxesForYear(taxYear);
						for(Tax t : taxList)
						{
							System.out.println(t);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					
					break;
				}
				default :
				{
					System.out.println("Invalid Choice...........");
					break;
				}
				}
				
				break;
			}
			case 4:
			{
				int financeChoice;
				System.out.println("\n **************  Financial Services  ********************* \n ");
				System.out.println("1. Add FinancialRecord");
				System.out.println("2.Get Record by employee ID");
				System.out.println("3. Get Record by Record ID");
				System.out.println("4. Get Record By Date ");
				
				System.out.println("\n Enter Your Choice :- ");
				financeChoice = sc .nextInt();
				
				switch(financeChoice)
				{
				case 1:
				{
					System.out.println("\n Enter Record ID (301 starts)  :  ");
					recordID = sc.nextInt();
					System.out.println("\n EmployeeID  :  ");
					employeeID = sc.nextInt();
					System.out.println("\n Record Date  :  ");
					String dateRecord = sc.next();
					try {
						recordDate = formatter.parse(dateRecord);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("\n Description  :  ");
					description = sc.next();
					System.out.println("\n Amount  :  ");
					amount = sc.nextDouble();
					System.out.println("\n Record Type  :  ");
					recordType = sc.next();
					
					try {
						financeService.addFinancialRecord(new FinancialRecord(recordID,employeeID,recordDate,description,amount,recordType));
					} catch (FinancialRecordException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 2:
				{
					List<FinancialRecord> recordList = new ArrayList();
					System.out.println("\n EmployeeID  :  ");
					employeeID = sc.nextInt();
					try {
						recordList = financeService.getFinancialRecordsForEmployee(employeeID);
						
						for(FinancialRecord f : recordList)
						{
							System.out.println(f);
						}
					} catch (FinancialRecordException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				}
				case 3:
				{
					System.out.println("\n Enter Record ID (301 starts)  :  ");
					recordID = sc.nextInt();
					try {
						System.out.println(financeService.getFinancialRecordById(recordID));
					} catch (FinancialRecordException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 4:
				{
					List<FinancialRecord> recordList = new ArrayList();
					System.out.println("\n Record Date  :  ");
					String dateRecord = sc.next();
					try {
						recordDate = formatter.parse(dateRecord);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						recordList = financeService.getFinancialRecordsForDate(recordDate);
						
						for(FinancialRecord f : recordList)
						{
							System.out.println(f);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				default :
				{
					System.out.println("INVALID CHOICE ...........");
				}
				}
				
				break;
			}
			default:
			{
				System.out.println("Invalid Choice.........");
				break;
			}
			}
			
		}
		
		

	}

	private static Date parseDate(String next) {
		// TODO Auto-generated method stub
		return null;
	}

}
