package com.SpringBootexample.repository;

import com.SpringBootexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

}