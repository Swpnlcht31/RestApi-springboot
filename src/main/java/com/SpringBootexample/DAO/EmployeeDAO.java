package com.SpringBootexample.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootexample.model.Employee;
import com.SpringBootexample.repository.EmployeeRepository;
@Service
public class EmployeeDAO {
	@Autowired // For Spring Boot
	EmployeeRepository employeerepository; 

public Employee save(Employee emp) {
	return employeerepository.save(emp);
}
public List<Employee> findAll(){
	return employeerepository.findAll();
}
public Employee findone(Long empid) {
return employeerepository.findOne(empid);	
}
public void delete(Employee emp) {
	employeerepository.delete(emp);
}
}
