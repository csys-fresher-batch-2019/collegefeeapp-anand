package sxc.student;

import java.util.Scanner;

public class TestDeleteStudent {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String regno = sc.next().toUpperCase();

		StudentDAOImplementation obj = StudentDAOImplementation.getInstance();
		Stud_Class s = Stud_Class.getInstance();

		s.setRegno(regno);
		obj.deleteStudent(s);
	}

}
