package sxc.student;

import java.util.ArrayList;
import java.util.Scanner;

import sxc.course.CourseDAOImplementation;
import sxc.degree.DegreeDAOImplementation;
import sxc.department.DeptDAOImplementation;
import sxc.util.Logger;

public class TestGetActiveStudentsByCourse {

	public static void main(String[] args) throws Exception {
		
		Logger logger=Logger.getInstance();
		Scanner sc=new Scanner(System.in);
		logger.info("Enter Department Name");
		String deptName=(sc.nextLine()).toUpperCase();
		logger.info("Enter Degree Name");
		String degName=(sc.nextLine()).toUpperCase();
		
		DeptDAOImplementation objDept=DeptDAOImplementation.getInstance();
		int deptId=objDept.getDepartmentId(deptName);
		logger.info("DEPT ID: "+deptId);

		DegreeDAOImplementation objDegree=  DegreeDAOImplementation.getInstance();
		int degId=objDegree.getDegreeId(degName);
		logger.info("DEGREE ID: "+degId);
		
		CourseDAOImplementation objCourse= CourseDAOImplementation.getInstance();
		int courseId=objCourse.getCourseId(degId, deptId);
		logger.info("COURSE ID: "+courseId);
		
		StudentDAOImplementation obj=StudentDAOImplementation.getInstance();
		ArrayList<Stud_Class> list=obj.getActiveStudentsByCourse(courseId);
		logger.info(list);
	}
	
}
