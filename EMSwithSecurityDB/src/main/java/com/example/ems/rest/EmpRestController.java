package com.example.ems.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeService;

@RestController
@RequestMapping("ems/api")
public class EmpRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmps(){
		return employeeService.getAll();
	}
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmpById(@PathVariable("id") int eid){
		return employeeService.getById(eid);
	}
	
	@PostMapping("/employees")  //id=0
	public Employee addEmp(@RequestBody Employee emp) {
		return employeeService.save(emp);
	}
	
	@PutMapping("/employees")
	public Employee updateEmp(@RequestBody Employee emp) {
		return employeeService.save(emp);
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmpById(@PathVariable("id") int eid) {
	employeeService.deletebyId(eid);
	return "Employee with ID: "+eid+" is deleted successfully";
	
	
	
	}	

}
