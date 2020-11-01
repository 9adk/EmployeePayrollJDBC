package com.employeepayrolltest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import com.employeepayroll.Employee;
import com.employeepayroll.EmployeePayrollService;
import com.employeepayroll.EmployeePayrollService.IOService;

import java.sql.SQLException;
import java.util.*;
public class EmployeeServiceTest {
	@Test
	public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() throws SQLException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<Employee> employeePayrollData = employeePayrollService.readEmployeePayrollDBData(IOService.DB_IO);
		assertEquals(5, employeePayrollData.size());
	}
}