package com.luv2code.mustachio.homemade.service;

import java.util.List;

import com.luv2code.mustachio.homemade.model.Student;


public interface StudentService {
	
	public Student savetudent(Student student);
	
	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public String deleteById(int theId);
	
	

	
}
