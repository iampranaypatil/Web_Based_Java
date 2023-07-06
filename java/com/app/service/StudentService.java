package com.app.service;

import java.util.List;

import com.app.entities.Student;

public interface StudentService {
	
	List<Student> getDetails();
	
	Student insertStudent(Student stud);
}
