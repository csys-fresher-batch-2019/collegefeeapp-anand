package sxc.student;

import java.util.Scanner;

import sxc.util.Logger;

public class TestGetCourseIdByRegno {

	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getInstance();
		Scanner sc = new Scanner(System.in);

		String regno = sc.nextLine().toUpperCase();

		StudentDAOImplementation stdObj = StudentDAOImplementation.getInstance();

		Stud_Class s = new Stud_Class();
		s.setRegno(regno);

		int courseId = stdObj.getCourseIdByRegno(s);
		logger.info("COURSE ID: " + courseId);

	}

}
