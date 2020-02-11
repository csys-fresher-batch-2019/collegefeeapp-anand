package sxc.student;

import java.util.Scanner;

import sxc.util.Logger;

public class TestAddStudent {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		String regno = (sc.nextLine()).toUpperCase();
		String name = (sc.nextLine()).toUpperCase();
		Logger.getInstance().info(name);
		int courseId = sc.nextInt();
		Logger.getInstance().info(courseId);
		String mail=sc.next();
		//String mail = sc.nextLine();

		StudentDAOImplementation obj = StudentDAOImplementation.getInstance();

		Stud_Class s = Stud_Class.getInstance();

		s.setCourse_id(courseId);
		s.setName(name);
		s.setRegno(regno);
		s.setMail(mail);

		obj.addStudent(s);
	}

}
