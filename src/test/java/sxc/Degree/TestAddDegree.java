package sxc.degree;

import java.util.Scanner;

public class TestAddDegree {

	public static void main(String[] args) throws Exception {
		
		DegreeDAOImplementation obj=DegreeDAOImplementation.getInstance();
		Scanner sc=new Scanner(System.in);
		String degName=(sc.next()).toUpperCase();
		int durationInYear=sc.nextInt();
		obj.addDegree(degName, durationInYear);
	}

}
