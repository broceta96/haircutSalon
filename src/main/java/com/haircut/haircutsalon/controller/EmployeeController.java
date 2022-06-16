package com.haircut.haircutsalon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.haircut.haircutsalon.entity.Employee;
import com.haircut.haircutsalon.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/listEmployee")
	public String getListEmployee(Model model) {
		
		List<Employee> employees = employeeService.findAll();
		
		model.addAttribute("employees", employees);
		
		return "list-employee";
	}
	
	@GetMapping("/addEmployee")
	public String showEmployeeForm(Model model) {
		
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "add-employee";
	}
	
	@PostMapping("/saveEmployee")
	public String save(@ModelAttribute Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		return "redirect:/listEmployee";
	}
	
	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
		
		Employee employee = employeeService.getSingleEmployee(id);
		
		model.addAttribute("employee", employee);
		
		return "add-employee";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		
		employeeService.deleteEmployee(id);
		
		return "redirect:/listEmployee";
	}
}
