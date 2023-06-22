package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;

@Repository // mandatory annotation to tell SC : following is a
//spring bean containing data access logic
public class DepartmentDaoImpl implements DepartmentDao {
	// dependency : SF
	@Autowired // mandatory dependency : required=true , Field level D.I
	private SessionFactory sf;// auto supplied by spring supplied
//: LocalSessionFactoryBean

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return sf.getCurrentSession()
				.createQuery("select d from Department d", Department.class)
				.getResultList();
	}

}
