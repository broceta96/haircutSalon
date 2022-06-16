package com.haircut.haircutsalon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haircut.haircutsalon.entity.Customer;
import com.haircut.haircutsalon.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getSingleCustomer(int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		Customer customer = null;
		
		if(optional.isPresent()) {
			customer = optional.get();
		}
		
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
	
	@Override
	public List<Customer> searchBy(String theName) {
		
		List<Customer> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = customerRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}
}
