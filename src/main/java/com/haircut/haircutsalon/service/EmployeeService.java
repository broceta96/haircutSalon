package com.haircut.haircutsalon.service;

import java.util.List;

import com.haircut.haircutsalon.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee getSingleEmployee(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int id);
}
