package com.employeepayrolltest;

import com.employeepayroll.DatabaseException;
import com.employeepayroll.Employee;
import com.employeepayroll.EmployeePayrollService;
import com.employeepayroll.EmployeePayrollService.IOService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import org.junit.Test;

public class EmployeeServiceTest {
	/**
	 * Usecase2: Retrieve data from the employee table
	 * 
	 * @throws DatabaseException
	 */
	@Test
	public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() throws DatabaseException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<Employee> employeePayrollData = employeePayrollService.readEmployeePayrollDBData(IOService.DB_IO);
		assertEquals(4, employeePayrollData.size());
	}

	/**
	 * Usecase3,Usecase4: Update salary for a particular employees
	 * 
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	@Test
	public void givenNewSalaryForEmployee_WhenUpdated_ShouldBeInSync() throws DatabaseException, SQLException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<Employee> employeePayrollData = employeePayrollService.readEmployeePayrollDBData(IOService.DB_IO);
		employeePayrollService.updateEmployeeSalary("Deepika", 5000000);
		employeePayrollService.readEmployeePayrollDBData(EmployeePayrollService.IOService.DB_IO);
		boolean result = employeePayrollService.checkEmployeeDataSync("Deepika");
		assertEquals(true, result);
	}

	/**
	 * Usecase5: to retrieve employees in the particular dates
	 * 
	 * @throws DatabaseException
	 */
	@Test
	public void givenEmployeePayrollInDB_WhenRetrievedForDateRange_ShouldMatchEmployeeCount() throws DatabaseException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<Employee> employeePayrollData = employeePayrollService.readEmployeePayrollDBData(IOService.DB_IO);
		int result = employeePayrollService.getEmployeeForDateRange(LocalDate.of(2019, 01, 01),
				LocalDate.of(2020, 01, 01));
		assertEquals(3, result);
	}
}