package com.example.jpacrud.ems.service;

import java.util.List;
import java.util.Optional;

import com.example.jpacrud.ems.entity.Employee;

public interface EmployeeService {
  
	List<Employee> getAll();
	Optional<Employee> getById(int id);
	Employee save(Employee emp); // for C and U
	
	//Employee update(Employee emp);
	void deletedbyId(int id);
}
