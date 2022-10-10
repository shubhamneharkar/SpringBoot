package com.springboot.service;

import java.util.List;

import com.springboot.model.Employee;

public interface EmployeeService {
	public String saveEmployee(Employee employee);

	public String saveEmployees(List<Employee> employees);

	public Employee getEmployeeById(Long id);

	public List<Employee> getEmployees();

	public String deleteEmployeeById(Long id);
	
	public Employee updateEmployee(Employee employee);
}
