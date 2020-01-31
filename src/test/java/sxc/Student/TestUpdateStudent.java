package sxc.Student;

import java.util.Scanner;

public class TestUpdateStudent {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		StudentDAOImplementation obj=StudentDAOImplementation.getInstance();
		
		Scanner sc=new Scanner(System.in);
		
		String regno=(sc.nextLine()).toUpperCase();
		String name=(sc.nextLine()).toUpperCase();
		
		obj.updateStudentName(regno,name);
	}

}
