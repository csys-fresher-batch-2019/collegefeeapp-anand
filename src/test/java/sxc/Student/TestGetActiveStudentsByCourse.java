package sxc.Student;

import java.util.ArrayList;
import java.util.Scanner;

import sxc.Course.CourseDAOImplementation;
import sxc.Degree.DegreeDAOImplementation;
import sxc.Department.DeptDAOImplementation;
import sxc.util.Logger;

public class TestGetActiveStudentsByCourse {

	public static void main(String[] args) throws Exception {
		
		Logger logger=Logger.getInstance();
		Scanner sc=new Scanner(System.in);
		logger.info("Enter Department Name");
		String deptName=(sc.nextLine()).toUpperCase();
		logger.info("Enter Degree Name");
		String degName=(sc.nextLine()).toUpperCase();
		
		DeptDAOImplementation objDept=new DeptDAOImplementation();
		int deptId=objDept.getDepartmentId(deptName);
		logger.info("DEPT ID: "+deptId);

		DegreeDAOImplementation objDegree= new DegreeDAOImplementation();
		int degId=objDegree.getDegreeId(degName);
		logger.info("DEGREE ID: "+degId);
		
		CourseDAOImplementation objCourse=new CourseDAOImplementation();
		int courseId=objCourse.getCourseId(degId, deptId);
		logger.info("COURSE ID: "+courseId);
		
		StudentDAOImplementation obj=new StudentDAOImplementation();
		ArrayList<Stud_Class> list=obj.getActiveStudentsByCourse(courseId);
		logger.info(list);
	}
	
}
