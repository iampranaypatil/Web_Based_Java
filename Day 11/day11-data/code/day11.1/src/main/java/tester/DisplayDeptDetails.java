package tester;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class DisplayDeptDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			DepartmentDao dao = new DepartmentDaoImpl();
			System.out.println("Enter dept name");
			Department department = dao.getDepartmentDetails(sc.next());
			System.out.println("Dept details " + department);
//			// confirm the proxy
//			System.out.println("Name of the Proxy class generated by hibernate using helper lib @ run time "
//					+ department.getEmpList().getClass());
			System.out.println("Emps from dept ");
			department.getEmpList().forEach(System.out::println);
		} // sf.close() --> cleaning up DBCP (db conn pool)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
