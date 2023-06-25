package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
	// derived finder method
	List<Employee> findByAssignedDeptId(Long deptId);

	Optional<Employee> findByEmailAndPassword
	(String email1, String password1);
}
