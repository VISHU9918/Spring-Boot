package com.example.jpacrud.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpacrud.entity.Student;
import com.example.jpacrud.service.StudentService;

@RestController
@RequestMapping("/sms/api")
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	// saving / creating a student
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	// getting student by id
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable("id") int sid) {
		return studentService.getById(sid);
	}
	
	//getting all students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAll();
	}
	
	// updating a sutdent
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.update(student);
	}
	
	// deleting student by id
	@DeleteMapping("/students/{id}")
	public String deleteStudentById(@PathVariable("id") int sid) {
		studentService.delete(sid);
		return "Student with id "+sid+" deleted seccessfully!";
	}
}
