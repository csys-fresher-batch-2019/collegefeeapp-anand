package sxc.Degree;

import java.util.Scanner;

public class TestAddDegree {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DegreeDAOImplementation obj=DegreeDAOImplementation.getInstance();
		Scanner sc=new Scanner(System.in);
		String degName=(sc.next()).toUpperCase();
		int durationInYear=sc.nextInt();
		obj.addDegree(degName, durationInYear);
	}

}
