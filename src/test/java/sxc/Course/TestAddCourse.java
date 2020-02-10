package sxc.course;

import java.util.Scanner;

import sxc.degree.DegreeDAOImplementation;
import sxc.department.DeptDAOImplementation;
import sxc.util.Logger;

public class TestAddCourse {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Logger logger = Logger.getInstance();

		DegreeDAOImplementation obj2 = DegreeDAOImplementation.getInstance();
		String degName = sc.next().toUpperCase();
		int degId = obj2.getDegreeId(degName);
		logger.info("DEGREE ID: " + degId);

		DeptDAOImplementation obj1 = DeptDAOImplementation.getInstance();
		String deptName = sc.next().toUpperCase();
		int deptId = obj1.getDepartmentId(deptName);
		logger.info("DEPT ID: " + deptId);

		CourseDAOImplementation obj3 = CourseDAOImplementation.getInstance();
		obj3.addCourse(deptId, degId);

		logger.info(degName + " ( '" + deptName + "' ) GENERATED");
	}
}
