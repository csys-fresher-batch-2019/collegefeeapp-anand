package sxc.course;

import java.util.Scanner;

public class TestDeleteCourse {
	
	public static void main(String[] args) throws Exception {
		
		CourseDAOImplementation obj= CourseDAOImplementation.getInstance();
		Scanner sc=new Scanner(System.in);
		int courseId=sc.nextInt();
		obj.deleteCourse(courseId);
		
	}
}
