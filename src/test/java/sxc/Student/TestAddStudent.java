package sxc.Student;

import java.util.Scanner;

public class TestAddStudent {

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		String regno=(sc.nextLine()).toUpperCase();
		String name = (sc.nextLine()).toUpperCase();
		int courseId=sc.nextInt();
		
		StudentDAOImplementation obj = new StudentDAOImplementation();
		obj.addStudent(regno,name,courseId);
	}

}
