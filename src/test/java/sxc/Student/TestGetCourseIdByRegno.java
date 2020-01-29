package sxc.Student;

import java.util.Scanner;

public class TestGetCourseIdByRegno {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String regno = sc.nextLine().toUpperCase();

		StudentDAOImplementation stdObj = new StudentDAOImplementation();
		int courseId = stdObj.getCourseIdByRegno(regno);
		System.out.println("COURSE ID: " + courseId);
	}

}
