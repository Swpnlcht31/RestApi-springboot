package com.SpringBootexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootexample.DAO.EmployeeDAO;
import com.SpringBootexample.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat.Value;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	@Autowired
	EmployeeDAO employeedeo;
	
	@PostMapping("/employees")
	public Employee createemployee(@Valid @RequestBody Employee emp) {
		return employeedeo.save(emp);
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeedeo.findAll();
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value ="id") Long empId ){
		Employee emp = employeedeo.findone(empId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value ="id") Long empId,@Valid @RequestBody Employee details){
		Employee emp = employeedeo.findone(empId); 
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		emp.setName(details.getName());
		emp.setDesignation(details.getDesignation());
		emp.setExpertise(details.getDesignation());
		Employee updateEmployee = employeedeo.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value ="id") Long empid){
		
	Employee emp= employeedeo.findone(empid);
	if(emp==null) {
		return ResponseEntity.notFound().build();
	}
	employeedeo.delete(emp);
	 return ResponseEntity.ok().build();
	}
}
