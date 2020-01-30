package sxc.Student;

import java.util.Scanner;

import sxc.util.Logger;

public class TestGetCourseIdByRegno {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Logger logger=Logger.getInstance();
		Scanner sc = new Scanner(System.in);

		String regno = sc.nextLine().toUpperCase();

		StudentDAOImplementation stdObj = new StudentDAOImplementation();
		int courseId = stdObj.getCourseIdByRegno(regno);
		logger.info("COURSE ID: " + courseId);
	}

}
