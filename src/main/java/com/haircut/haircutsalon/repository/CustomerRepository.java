package com.haircut.haircutsalon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haircut.haircutsalon.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public List<Customer> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
