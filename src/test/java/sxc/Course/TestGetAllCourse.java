package sxc.Course;

import java.util.ArrayList;

public class TestGetAllCourse {
	public static void main(String[] args) throws Exception {

		CourseDAOImplementation obj = new CourseDAOImplementation();
		ArrayList<Course> list = obj.getAllCourse();
		System.out.println(list);
	}
}
