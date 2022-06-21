package com.haircut.haircutsalon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.haircut.haircutsalon.entity.Customer;
import com.haircut.haircutsalon.entity.Haircut;
import com.haircut.haircutsalon.service.CustomerService;
import com.haircut.haircutsalon.service.HaircutService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private HaircutService haircutService;
	

	private List<Haircut> haircuts;
		
	@PostConstruct
	private void loadData() {
	
		haircuts = new ArrayList<>();
		haircuts.add(new Haircut("Mohawk"));
		haircuts.add(new Haircut("Bold"));
		haircuts.add(new Haircut("Caesar Haircut"));
		haircuts.add(new Haircut("Buzz Cut"));
		haircuts.add(new Haircut("Military Haircut"));
		haircuts.add(new Haircut("Undercut"));
		haircuts.add(new Haircut("French Crop"));
	}
	
	
	@GetMapping("/")
	public String listCustomers(Model model) {
		
		List<Customer> customers = customerService.findAll();
		
		model.addAttribute("customers", customers);
		
		return "homepage";
	}
	
	@GetMapping("/addCustomer")
	public String saveCustomer(Model model) {
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "add-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return "redirect:/";
	}
	
	@GetMapping("/selectHaircut")
	public String selectHair(@RequestParam("hairId") int id, Model model) {
		
		Customer customer = customerService.getSingleCustomer(id);
				
		Haircut haircut = new Haircut();
		
		customer.add(haircut);
		
		model.addAttribute("haircut", haircut);
		model.addAttribute("haircuts", haircuts);
		
		return "select-hair";
	}
	
	@PostMapping("/saveHaircut")
	public String generateHaircut(@ModelAttribute Haircut haircut) {
		
		Customer customer = haircut.getCustomer();
		
		customer.add(haircut);
		
		haircutService.saveHaircuts(haircut);
		
		return "redirect:/";
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = customerService.getSingleCustomer(id);
		
		model.addAttribute("customer", customer);
		
		return "add-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		customerService.deleteCustomer(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/infoCustomer")
	public String customerInformation(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = customerService.getSingleCustomer(id);
		
		List<Haircut> hair = customer.getHaircut();
				
		model.addAttribute("haircut", hair);
		model.addAttribute("customer", customer);
		
		return "info-customer";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("customerName") String theName, Model theModel) {
		
		List<Customer> customers = customerService.searchBy(theName);
		
		theModel.addAttribute("customers", customers);
		
		return "homepage";
	}
	
}
