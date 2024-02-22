package com.torryharris.employeespringbootdemo.entity;

public class Employee {	
	private Integer employeeId;
	private String employeeName;
	private String designation;
	private Integer salary;
	private Double experienceInYears;
	
	public Employee() {
	}

	public Employee(Integer employeeId, String employeeName, String designation, Integer salary,
			Double experienceInYears) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.designation = designation;
		this.salary = salary;
		this.experienceInYears = experienceInYears;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Double getExperienceInYears() {
		return experienceInYears;
	}

	public void setExperienceInYears(Double experienceInYears) {
		this.experienceInYears = experienceInYears;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", designation=" + designation
				+ ", salary=" + salary + ", experienceInYears=" + experienceInYears + "]";
	}
	
	
	
}
