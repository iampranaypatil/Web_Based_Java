package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

public class ReStoreEmpImage {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			EmployeeDao dao = new EmployeeDaoImpl();
			System.out.println("Enter emp id");
			long empId=sc.nextLong();
			sc.nextLine();//reads off pending new line
			System.out.println("Enter new file name with path");
			System.out.println(dao.restoreImage(empId, sc.nextLine()));
		} // sf.close() --> cleaning up DBCP (db conn pool)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
