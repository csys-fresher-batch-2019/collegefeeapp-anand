package sxc.Student;

import java.util.ArrayList;
import java.util.Scanner;

import sxc.Course.CourseDAOImplementation;
import sxc.Degree.DegreeDAOImplementation;
import sxc.Department.DeptDAOImplementation;

public class TestGetActiveStudentsByCourse {

	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Department Name");
		String deptName=(sc.nextLine()).toUpperCase();
		System.out.println("Enter Degree Name");
		String degName=(sc.nextLine()).toUpperCase();
		
		DeptDAOImplementation objDept=new DeptDAOImplementation();
		int deptId=objDept.getDepartmentId(deptName);
		System.out.println("DEPT ID: "+deptId);

		DegreeDAOImplementation objDegree= new DegreeDAOImplementation();
		int degId=objDegree.getDegreeId(degName);
		System.out.println("DEGREE ID: "+degId);
		
		CourseDAOImplementation objCourse=new CourseDAOImplementation();
		int courseId=objCourse.getCourseId(degId, deptId);
		System.out.println("COURSE ID: "+courseId);
		
		StudentDAOImplementation obj=new StudentDAOImplementation();
		ArrayList<Stud_Class> list=obj.getActiveStudentsByCourse(courseId);
		System.out.println(list);
	}
	
}
