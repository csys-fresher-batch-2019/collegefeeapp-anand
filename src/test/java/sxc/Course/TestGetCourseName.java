package sxc.Course;

import java.util.Scanner;

import sxc.util.Logger;

public class TestGetCourseName {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Logger logger=Logger.getInstance();
		Scanner sc=new Scanner(System.in);
		int courseId=sc.nextInt();
		
		CourseDAOImplementation obj=new CourseDAOImplementation();
		String courseName=	obj.getCourseName(courseId);
		logger.info(courseName);
	}

}
