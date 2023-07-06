package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Course;
import com.app.repository.CourseRepo;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepo repo;
	@Override
	public Course insertCourse(Course c) {
		
		return repo.save(c);
	}
	@Override
	public List<Course> getDetails() {
		
		return repo.findAll();
	}
	@Override
	public Course updateCourse(Course c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}
	@Override
	public String deleteCourse(Integer id) {
		String msg="Invalid Id";
		if(repo.existsById(id)) {
			repo.deleteById(id);
			msg="Deleted Successfully "+id;
		}
		return msg;
	}
	
	

}
