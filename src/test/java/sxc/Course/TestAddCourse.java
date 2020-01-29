package sxc.Course;

import java.util.Scanner;

import sxc.Degree.DegreeDAOImplementation;
import sxc.Department.DeptDAOImplementation;

import java.sql.*;

public class TestAddCourse {

	public static void main(String[] args) throws Exception {
		
		Scanner sc= new Scanner(System.in);
		
		DeptDAOImplementation obj1= new DeptDAOImplementation();
		String deptName=sc.next().toUpperCase();
		int deptId = obj1.getDepartmentId (deptName);
		System.out.println("DEPT ID: "+deptId);
		
		DegreeDAOImplementation obj2=new DegreeDAOImplementation();
		String degName=sc.next().toUpperCase();
		int degId=obj2.getDegreeId(degName);
		System.out.println("DEGREE ID: "+degId);
		
		CourseDAOImplementation obj3=new CourseDAOImplementation();	
		obj3.addCourse(deptId,degId);
		
		System.out.println(degName+ " ( '"+deptName+"' ) GENERATED");
	}
}
