package com.project.Backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.project.Backend.model.Employee;
import com.project.Backend.service.EmployeeService;

@RestController
@RequestMapping("employees")
@CrossOrigin("*")
public class Controller {
	
	@Autowired
	private	EmployeeService employeeService;
	
	//viewAllEmployees
	@GetMapping
	public List<Employee> viewAllEmployees() {
		return employeeService.viewAllEmployees();
	}
	
	//viewEmployeeById
	@GetMapping("{postId}")
	public Employee viewEmployee(@PathVariable("postId") long postId) {
		return employeeService.viewEmployee(postId);
	}
	
	//addEmployee
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		 employeeService.addEmployee(employee);
		 return employeeService.viewEmployee(employee.getEmpId());
	}
	
	//updateEmployee
	@PutMapping("{postId}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("postId") long id) {
		employeeService.updateEmployee(employee,id);
		return employeeService.viewEmployee(employee.getEmpId());
	}
	
	//deleteEmployee
	@DeleteMapping("{postId}")
	public String deleteEmployee(@PathVariable("postId") long postId) {
		employeeService.deleteEmployee(postId);
		return "Deleted";
	}
	
	//forLoadingDataToDatabase
	@GetMapping("load")
	public List<Employee> load() {
		return employeeService.load();
	}
}
