package sxc.Course;

import java.util.ArrayList;

import sxc.util.Logger;

public class TestGetAllCourse {
	public static void main(String[] args) throws Exception {

		Logger logger=Logger.getInstance();
		CourseDAOImplementation obj = CourseDAOImplementation.getInstance();
		ArrayList<Course> list = obj.getAllCourse();
		logger.info(list.toString());
	}
}
