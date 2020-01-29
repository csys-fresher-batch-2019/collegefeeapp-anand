package sxc.Course;

import java.util.Scanner;

public class TestGetCourseName {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int courseId=sc.nextInt();
		
		CourseDAOImplementation obj=new CourseDAOImplementation();
		String courseName=	obj.getCourseName(courseId);
		System.out.println(courseName);
	}

}
