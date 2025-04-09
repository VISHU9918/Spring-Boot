package com.example.student.rest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.beans.Student;

@RestController
@RequestMapping("/api")
public class MyRestController {
		
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> slist = new ArrayList<Student>();
		slist.add(new Student(101,"ABC",8.2, "Hyd"));
		slist.add(new Student(102,"XYZ",8.1, "Che"));
		slist.add(new Student(103,"ASDF",9.2, "Blr"));
		slist.add(new Student(104,"PQR",9.1, "Hyd"));
		slist.add(new Student(105,"QWERTY",7.2, "Mum"));
		
		return slist;  // Jackson => List<Student> => JSON Array
	}
	
	@GetMapping("/students/{sid}") // URL -> Path Variable
	public Student getStudentById(@PathVariable("sid") int sid) {
		
		List<Student> slist = new ArrayList<Student>();
		slist.add(new Student(101,"ABC",8.2, "Hyd")); // 0
		slist.add(new Student(102,"XYZ",8.1, "Che"));
		slist.add(new Student(103,"ASDF",9.2, "Blr"));
		slist.add(new Student(104,"PQR",9.1, "Hyd"));
		slist.add(new Student(105,"QWERTY",7.2, "Mum")); // 1
				
		return slist.get(sid); // Jackson => Student => JSON object
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {  // JSON => student
		System.out.println(student.getId()+" "+student.getName()+" "+student.getGpa()+"  "+student.getCity());;
		
		return student;
	}
	
	
	
}
