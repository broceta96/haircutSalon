package com.haircut.haircutsalon.service;

import java.util.List;

import com.haircut.haircutsalon.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	
	public Customer getSingleCustomer(int id);
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomer(int id);
	
	public List<Customer> searchBy(String theName);
}
