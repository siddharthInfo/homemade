package com.luv2code.mustachio.homemade.controller;

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

import com.luv2code.mustachio.homemade.model.Student;
import com.luv2code.mustachio.homemade.service.StudentService;

@RestController
@RequestMapping("/student")
public class Controller {
	
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/add")
	public Student add(@RequestBody Student student) {
		
		student.setId(0);
		
		studentservice.savetudent(student);
		return student;
	}

		@GetMapping("/findall")
		public List<Student> findAll()
		{
			return studentservice.findAll();
		}
		
		@GetMapping("/findall/{studentId}")
		public Student findById(@PathVariable int studentId) {
			
			Student student = studentservice.findById(studentId);
			
			if(student == null) {
				throw new RuntimeException("the student is not present:-"+studentId);
			}
			return student;
		}
		
		@PutMapping("/update")
		public Student updateEmployee(@RequestBody Student theStudent) {
			
			studentservice.savetudent(theStudent);
			return theStudent;
			
		}
		
		@DeleteMapping("/findall/{studentId}")
		public String deleteStudent(@PathVariable int studentId ) {
			
			 Student theStudent =  studentservice.findById(studentId);
			 if(theStudent == null) {
				 throw new RuntimeException("the id not found:-"+studentId);
			 }
			 studentservice.deleteById(studentId);
			 
			return "the employee id is been deleted:-"+studentId;
		}
	
		

}
