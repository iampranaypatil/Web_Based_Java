package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.entities.Course;
import com.app.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService service;
	
	@PostMapping("/insert")
	public Course insert(@RequestBody Course c) {
		return service.insertCourse(c);
	}
	
	@GetMapping("/details")
	public List<Course> details(){
		return service.getDetails();
	}
	
	@PutMapping("/update")
	public Course update(@RequestBody Course c) {
		return service.updateCourse(c);
	}
	
	@DeleteMapping("/{id}")
	public ApiResponse delete(@PathVariable Integer id) {
		System.out.println(id);
		return new ApiResponse(service.deleteCourse(id));
	}
	
	
}
