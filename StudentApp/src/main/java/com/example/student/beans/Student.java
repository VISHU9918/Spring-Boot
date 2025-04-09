package com.example.student.beans;

// Bean (Student.class) or POJO or entity

public class Student {
    // data 
	private int id;
	private String name;
	private double gpa;
	private String city;
	
	public Student(int id, String name, double gpa, String city) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.city = city;
	}

	
	public Student() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
