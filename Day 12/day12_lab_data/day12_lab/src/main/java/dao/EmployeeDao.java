package dao;

import java.io.IOException;

import pojos.Employee;

public interface EmployeeDao {
//add new emp
	String addNewEmployee(Employee emp, long deptId);

	// delete emp details
	String deleteEmpDetails(String deptName, String empEmail);

	Employee getEmpDetails(long empId);

	// add a method for storing emp image in db
	String storeImage(long empId, String path) throws IOException;

	// add a method for re storing emp image from db
	String restoreImage(long empId, String path) throws IOException;

}
