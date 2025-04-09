package com.example.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ems.entity.Employee;
import com.example.ems.repo.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getById(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public void deletebyId(int id) {
		employeeRepository.deleteById(id);
		
	}

}
