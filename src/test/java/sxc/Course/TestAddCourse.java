package sxc.Course;

import java.util.Scanner;

import sxc.Degree.DegreeDAOImplementation;
import sxc.Department.DeptDAOImplementation;
import sxc.util.Logger;

public class TestAddCourse {

	public static void main(String[] args) throws Exception {
		
		Scanner sc= new Scanner(System.in);
		
		Logger logger=Logger.getInstance();
		DeptDAOImplementation obj1=  DeptDAOImplementation.getInstance();
		String deptName=sc.next().toUpperCase();
		int deptId = obj1.getDepartmentId (deptName);
		logger.info("DEPT ID: "+deptId);
		
		DegreeDAOImplementation obj2=DegreeDAOImplementation.getInstance();
		String degName=sc.next().toUpperCase();
		int degId=obj2.getDegreeId(degName);
		logger.info("DEGREE ID: "+degId);
		
		CourseDAOImplementation obj3=CourseDAOImplementation.getInstance();	
		obj3.addCourse(deptId,degId);
		
		logger.info(degName+ " ( '"+deptName+"' ) GENERATED");
	}
}
