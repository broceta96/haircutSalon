package com.haircut.haircutsalon.employee;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.haircut.haircutsalon.entity.Employee;
import com.haircut.haircutsalon.repository.EmployeeRepository;
import com.haircut.haircutsalon.service.EmployeeServiceImpl;


@ExtendWith(MockitoExtension.class)
public class EmployeeTest {
	
	@Mock
	private EmployeeRepository repository;
	
	@InjectMocks
	private EmployeeServiceImpl service;

	@Test	
	public void canGetAllEmployee() {
		service.findAll();		
		verify(repository).findAll();		
	}
	
	@Test
	public void canAddEmployee() {
		Employee employee = new Employee("Dwayne", "Johnson", "therock@gmail.com");
		
		service.saveEmployee(employee);
		
		ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
		
		verify(repository).save(employeeCaptor.capture());
		
		Employee captured = employeeCaptor.getValue();
		assertThat(captured).isEqualTo(employee);
	}
	
	@Test
	public void canDeleteEmployee() {
		Employee employee = new Employee("Nebojsa", "Glogovac", "glogovac@gmail.com");
		employee.setId(1);
		service.deleteEmployee(employee.getId());
		verify(repository).deleteById(employee.getId());
	}
	
	@Test
	public void canGetSingleEmployee() {
		Employee employee = new Employee("Bata", "Stojkovic", "bata@gmail.com");
		employee.setId(2);
		service.getSingleEmployee(employee.getId());
		verify(repository).findById(employee.getId());
	}
	
}
