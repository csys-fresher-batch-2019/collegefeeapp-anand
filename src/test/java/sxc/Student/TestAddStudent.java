package sxc.student;

import java.util.Scanner;

public class TestAddStudent {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		String regno = (sc.nextLine()).toUpperCase();
		String name = (sc.nextLine()).toUpperCase();
		int courseId = sc.nextInt();

		StudentDAOImplementation obj = StudentDAOImplementation.getInstance();

		Stud_Class s = Stud_Class.getInstance();

		s.setCourse_id(courseId);
		s.setName(name);
		s.setRegno(regno);

		obj.addStudent(s);
	}

}
