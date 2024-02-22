package com.torryharris.employeespringbootdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torryharris.employeespringbootdemo.entity.Employee;
import com.torryharris.employeespringbootdemo.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/employee-service")
public class EmployeeController {
	
	private static List<Employee> empList;
	
	static {
		empList=new ArrayList<>();
		empList.add(new Employee(1001, "John", "Manager", 75000,5.6));
		empList.add(new Employee(1002, "Jenny", "Sr. Manager", 85000,8.2));
		empList.add(new Employee(1003, "Amar", "Tech Lead", 70000,4.3));
		empList.add(new Employee(1004, "Akbar", "Architect", 100000,10.3));
		empList.add(new Employee(1005, "Anthony", "Project Manager", 95000,7.5));
	}
	
	@GetMapping("/employee")	
	public List<Employee> getAllEmployees(){
		return empList;
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployeeById(@PathVariable Integer employeeId) {	
		for(Employee emp:empList) {
			if(emp.getEmployeeId().equals(employeeId)) {
				return emp;
			}
		}
		throw new EmployeeNotFoundException("Employee Not found with ID:"+employeeId);
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		empList.add(employee);
		return "Employee added successfully with Employee ID:"+employee.getEmployeeId();
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployeeById(@PathVariable Integer employeeId) {
		Employee emp=getEmployeeById(employeeId);
		if(emp!=null) {
			empList.remove(emp);
			return "Employee Deleted successfully with Employee ID:"+employeeId;
		}else {
			return "Employee Not Found with Employee ID:"+employeeId;
		}
	}
	
	@PutMapping("/employee/{employeeId}")
	public String updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee updatedEmployee) {
		Employee emp=getEmployeeById(employeeId);
		if(emp!=null) {
			emp.setEmployeeName(updatedEmployee.getEmployeeName());
			emp.setDesignation(updatedEmployee.getDesignation());
			emp.setSalary(updatedEmployee.getSalary());
			emp.setExperienceInYears(updatedEmployee.getExperienceInYears());		
			return "Employee Updated: \n"+emp.toString();
			
		}else {
			return "Employee Not found with ID: "+employeeId;
		}
	}
}
