package com.springboot.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;
import com.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public String saveEmployee(Employee employee) {
		repository.save(employee);
		return "Employee " + employee.getFirstName() + " added.";
	}

	@Override
	public String saveEmployees(List<Employee> employees) {
		List<Employee> saveAll = repository.saveAll(employees);
		return "All employees added successfully.";
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> all = repository.findAll();
		return all;
	}

	@Override
	public String deleteEmployeeById(Long id) {
		Employee employee = repository.findById(id).orElse(null);
		repository.deleteById(id);
		return "Employee of id " + id + " & name " + employee.getFirstName() + " is deleted from database.";
	}

	@Override
	public Employee updateEmployee(Employee updateEmployee) {
		Employee existingEmployee = repository.findById(updateEmployee.getId()).orElse(null);
		existingEmployee.setFirstName(updateEmployee.getFirstName());
		existingEmployee.setLastName(updateEmployee.getLastName());
		existingEmployee.setEmail(updateEmployee.getEmail());
		return repository.save(existingEmployee);
	}

}
