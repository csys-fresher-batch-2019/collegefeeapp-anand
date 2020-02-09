package sxc.course;

import java.util.Scanner;

import sxc.degree.DegreeDAOImplementation;
import sxc.department.DeptDAOImplementation;
import sxc.util.Logger;

public class TestGetCourseId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Logger logger = Logger.getInstance();

		DeptDAOImplementation obj1 =  DeptDAOImplementation.getInstance();
		DegreeDAOImplementation obj2 =  DegreeDAOImplementation.getInstance();
		CourseDAOImplementation obj3 = CourseDAOImplementation.getInstance();

		String deptName = sc.next();
		String degName = sc.next();

		int deptId = obj1.getDepartmentId(deptName);
		int degId = obj2.getDegreeId(degName);

		int course_id = obj3.getCourseId(degId, deptId);
		logger.info(course_id);

	}

}
