package com.EmployeePayrollServiceProblem;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.EmployeePayrollServiceProblem.EmployeePayrollService.IOService;


public class EmployeePayrollServiceTest {

	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEnteries() {
		EmployeePayrollData[] arrayOfEmps= {
				new EmployeePayrollData(1,"Mohd Arshad", 350000.0),
				new EmployeePayrollData(2,"Arshad", 400000.0),
				new EmployeePayrollData(3,"Ars", 500000.0)
		};
		EmployeePayrollService employeePayrollService;
		employeePayrollService=new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		employeePayrollService.printData(IOService.FILE_IO);
		long entries=employeePayrollService.countEntries(IOService.FILE_IO);
		Assert.assertEquals(3,entries);	
	}
	
	@Test
	public void givenFileOnReadingFileShouldMatchEmployeeCount() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<EmployeePayrollData> entries = employeePayrollService.readPayrollData(IOService.FILE_IO);
	}
}
