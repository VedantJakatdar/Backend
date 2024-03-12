package com.project.Backend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Backend.model.Employee;
import com.project.Backend.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	public List<Employee> viewAllEmployees() {
		return repo.findAll();
	}
	
	public Employee addEmployee(Employee employee) {
		return	repo.save(employee);
	}
	
	public Employee viewEmployee(long postId) {
		return repo.findById(postId).orElse(null);
	}
	
	public Employee updateEmployee(Employee employee,long id) {
		Employee employee1 = repo.findById(id).orElse(null);					
		
		employee1.setEmpId(employee.getEmpId());
		employee1.setFirstName(employee.getFirstName());
		employee1.setLastName(employee.getLastName());
		employee1.setEmailId(employee.getEmailId());
		
		return repo.save(employee1);
		
	
	}
	
	public void deleteEmployee(long postId) {
		repo.deleteById(postId);
	}
	
	public List<Employee> load() {
		List<Employee> employees = new ArrayList<Employee>(Arrays.asList(
				
						new Employee(1,"Vedant","Jakatdar","vedant@tcs.com"),
						new Employee(2,"Shubham","Jadhav","shubham@capgemini.com"),
						new Employee(3,"Sandip","Khaire","sandip@polycab.com"),
						new Employee(4,"Rohan","Chavan","rohan@hdfc.com")
				
				));
				
		return repo.saveAll(employees);
	}	

}
