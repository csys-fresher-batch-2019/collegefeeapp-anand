package sxc.Student;

import java.util.Scanner;

public class TestUpdateStudent {

	public static void main(String[] args) throws Exception {
	
		StudentDAOImplementation obj=StudentDAOImplementation.getInstance();
		
		Scanner sc=new Scanner(System.in);
		
		String regno=(sc.nextLine()).toUpperCase();
		String name=(sc.nextLine()).toUpperCase();
		
		Stud_Class s = new Stud_Class();
		s.setRegno(regno);
		s.setName(name);
		
		obj.updateStudentName(s);
	}

}
