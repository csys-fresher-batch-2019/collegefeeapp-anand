package sxc.Student;

import java.util.Scanner;

public class TestDeleteStudent {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String regno =sc.next().toUpperCase();
		
		StudentDAOImplementation obj =StudentDAOImplementation.getInstance();
		obj.deleteStudent(regno);
	}

}
