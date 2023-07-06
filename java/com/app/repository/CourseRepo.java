package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
