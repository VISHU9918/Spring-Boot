package com.example.jpacrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpacrud.dao.StudentDao;
import com.example.jpacrud.entity.Student;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService  {

	@Autowired
	private StudentDao studentDao;
	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentDao.getAll();
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return studentDao.getById(id);
	}

	@Override
	public Student save(Student stud) {
		// TODO Auto-generated method stub
		return studentDao.save(stud);
	}

	@Override
	public Student update(Student stud) {
		// TODO Auto-generated method stub
		return studentDao.update(stud);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		studentDao.deleteById(id);
		
	}

}
