package com.app.service;

import java.util.List;

import com.app.entities.Course;

public interface CourseService {
	Course insertCourse(Course c);
	
	List<Course> getDetails();
	
	Course updateCourse(Course c);
	
	String deleteCourse(Integer id);
}
