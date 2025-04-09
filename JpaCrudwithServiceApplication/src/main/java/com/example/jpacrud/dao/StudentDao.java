package com.example.jpacrud.dao;

import java.util.List;

import com.example.jpacrud.entity.Student;

public interface StudentDao {
	    // C - in CRUD
		public Student save(Student student);
		
		// R (1) - in CRUD
		public Student getById(int sid);
		
		// R(2) - in CRUD
		public List<Student> getAll();
		
		// U - in CRUD
		public Student update(Student student);
		
		// D- in CRUD
		public void deleteById(int sid);
}
