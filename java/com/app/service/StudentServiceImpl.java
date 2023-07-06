package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Student;
import com.app.repository.StudentRepoIF;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepoIF repo;
	@Override
	public List<Student> getDetails() {
		
		return repo.findAll();
	}
	@Override
	public Student insertStudent(Student stud) {
		
		return repo.save(stud);
	}
	

}
