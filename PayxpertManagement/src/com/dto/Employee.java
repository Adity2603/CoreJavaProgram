package com.dto;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.time.LocalDate;

public class Employee {
	
	
    private int employeeID;
	private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String position;
    private Date joiningDate;
    private Date terminationDate;
    

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(int employeeID, String firstName, String lastName, Date dateOfBirth, String gender,
                    String email, String phoneNumber, String address, String position, Date joiningDate,
                    Date terminationDate) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.position = position;
        this.joiningDate = joiningDate;
        this.terminationDate = terminationDate;
    }

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getJoiningDate() {
        return  joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate =  joiningDate;
    }

    public Date getTerminationDate() {
        return  terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate =  terminationDate;
    }

    // Method to calculate age
    public int calculateAge() {
    	Calendar currentDate = Calendar.getInstance(); // Get current date
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(dateOfBirth); // Set birth date

        int currentYear = currentDate.get(Calendar.YEAR);
        int birthYear = birthDate.get(Calendar.YEAR);

        int age = currentYear - birthYear;

        // Adjust age if the current date hasn't occurred yet
        if (currentDate.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }
    
    @Override
   	public String toString() {
   		return "****************************************************\n\n"+
   				"employeeID = " + employeeID +"\n\n"+
   				"firstName = " + firstName +"\n\n"+
   				"lastName = " + lastName+ "\n\n"+
   				"dateOfBirth = " + dateOfBirth + "\n\n"+
   				"gender = " + gender + "\n\n"+
   				"email = " + email + "\n\n"+
   				"phone Number= " + phoneNumber + "\n\n"+
   				"address=" + address + "\n\n"+
   				"position = " + position + "\n\n"+
   				"joiningDate = " + joiningDate+ "\n\n"+
   				"terminationDate = " + terminationDate +"\n"+
   				"****************************************************\n\n";
   	}
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeID == employee.employeeID &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(dateOfBirth, employee.dateOfBirth) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(phoneNumber, employee.phoneNumber) &&
                Objects.equals(address, employee.address) &&
                Objects.equals(position, employee.position) &&
                Objects.equals(joiningDate, employee.joiningDate) &&
                Objects.equals(terminationDate, employee.terminationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, firstName, lastName, dateOfBirth, gender, email, phoneNumber, address, position, joiningDate, terminationDate);
    }
    
}
