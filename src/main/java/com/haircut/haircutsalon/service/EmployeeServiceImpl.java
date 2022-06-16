package com.haircut.haircutsalon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haircut.haircutsalon.entity.Employee;
import com.haircut.haircutsalon.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getSingleEmployee(int id) {
		Optional<Employee> opt = employeeRepository.findById(id);
		Employee employee = null;
		
		if(opt.isPresent()) {
			employee = opt.get();
		}
		
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	
}
