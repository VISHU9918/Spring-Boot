package com.example.jpacrud.service;

import java.util.List;

import com.example.jpacrud.entity.Student;

public interface StudentService {
	public List<Student> getAll();
	public Student getById(int id);
	public Student save(Student stud);
	public Student update(Student stud);
	public void delete(int id);

}
