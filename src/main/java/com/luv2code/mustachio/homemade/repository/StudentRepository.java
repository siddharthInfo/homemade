package com.luv2code.mustachio.homemade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.mustachio.homemade.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
