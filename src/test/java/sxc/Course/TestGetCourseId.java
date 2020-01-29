package sxc.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import sxc.Degree.DegreeDAOImplementation;
import sxc.Department.DeptDAOImplementation;

public class TestGetCourseId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		DeptDAOImplementation obj1 = new DeptDAOImplementation();
		DegreeDAOImplementation obj2 = new DegreeDAOImplementation();
		CourseDAOImplementation obj3 = new CourseDAOImplementation();

		String deptName = sc.next();
		String degName = sc.next();

		int deptId = obj1.getDepartmentId(deptName);
		int degId = obj2.getDegreeId(degName);

		int course_id = obj3.getCourseId(degId, deptId);
		System.out.println(course_id);

	}

}
