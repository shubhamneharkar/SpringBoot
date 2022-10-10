package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.service.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@PostMapping("/addEmpoyee")
	public String postEmployee(@RequestBody Employee employee) {
		return employeeServiceImpl.saveEmployee(employee);
	}

	@PostMapping("/addEmpoyees")
	public String postEmployees(@RequestBody List<Employee> employees) {
		return employeeServiceImpl.saveEmployees(employees);
	}

	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return employeeServiceImpl.getEmployeeById(id);
	}

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return employeeServiceImpl.getEmployees();
	}

	@DeleteMapping("/deleteEmployeeById/{id}")
	public String deleteEmployeeById(@PathVariable Long id) {
		return employeeServiceImpl.deleteEmployeeById(id);
	}

	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeServiceImpl.updateEmployee(employee);
	}
}
