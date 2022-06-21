package com.haircut.haircutsalon.customer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.haircut.haircutsalon.entity.Customer;
import com.haircut.haircutsalon.repository.CustomerRepository;
import com.haircut.haircutsalon.service.CustomerServiceImpl;


@ExtendWith(MockitoExtension.class)
public class CustomerTest {

	@Mock
	private CustomerRepository repository;
	
	@InjectMocks
	private CustomerServiceImpl service;

	@Test	
	public void canGetAllCustomers() {
		service.findAll();		
		verify(repository).findAll();		
	}
	
	@Test
	public void canAddCustomer() {
		Customer customer = new Customer("Zoran", "Radmilovic", "radovantreci@gmail.com");
		
		service.saveCustomer(customer);
		
		ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
		
		verify(repository).save(customerCaptor.capture());
		
		Customer captured = customerCaptor.getValue();
		assertThat(captured).isEqualTo(customer);
	}
	
	@Test
	public void canDeleteCustomer() {
		Customer customer = new Customer("John", "Cena", "johncena@gmail.com");
		customer.setId(1);
		service.deleteCustomer(customer.getId());
		verify(repository).deleteById(customer.getId());
	}
	
	@Test
	public void canGetSingleCustomer() {
		Customer customer = new Customer("Mark", "Felix", "markfelix@gmail.com");
		customer.setId(2);
		service.getSingleCustomer(customer.getId());
		verify(repository).findById(customer.getId());
	}
}
