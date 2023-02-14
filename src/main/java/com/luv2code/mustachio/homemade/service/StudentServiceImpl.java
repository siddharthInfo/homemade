package com.luv2code.mustachio.homemade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.mustachio.homemade.model.Student;
import com.luv2code.mustachio.homemade.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public Student savetudent(Student student) {
		
		return studentRepository.save(student);
	}


	@Override
	public List<Student> findAll() {
		
		return studentRepository.findAll();
	}


	@Override
	public Student findById(int theId) {
		
		Optional<Student> result = studentRepository.findById(theId);
		
		Student theStudent = null;
		
		if(result.isPresent()) {
			theStudent = result.get();
		}
		else {
			throw new RuntimeException("did not find the id :-"+theId);
		}
		
		return theStudent;
	}


	@Override
	public String deleteById(int theId) {
		
		studentRepository.deleteById(theId);
		return "the student is deleted";
	}

	
	
}
