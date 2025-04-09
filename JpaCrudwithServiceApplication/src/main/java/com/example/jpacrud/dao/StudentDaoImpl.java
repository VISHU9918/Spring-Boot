package com.example.jpacrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpacrud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao  {
    @Autowired
    private EntityManager entityManager;
	@Override
	@Transactional
	public Student save(Student student) {
		entityManager.persist(student);	 // save to the database
		return student;
	}

	@Override
	public Student getById(int sid) {
		Student student = entityManager.find(Student.class, sid);
		return student;
	}

	@Override
	public List<Student> getAll() {
		TypedQuery<Student> query = entityManager.createQuery("from Student",Student.class);
		List<Student> studentList = query.getResultList();
		return studentList;
	}

	@Override
	@Transactional
	public Student update(Student student) {
		entityManager.merge(student);
		return student;
	}

	@Override
	@Transactional
	public void deleteById(int sid) {
		Student student = entityManager.find(Student.class, sid);
		entityManager.remove(student);
		
	}

}
