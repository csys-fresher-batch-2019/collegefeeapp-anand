package sxc.Degree;

import java.util.Scanner;

public class TestGetDegreeName {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DegreeDAOImplementation obj = new DegreeDAOImplementation();
		Scanner sc= new Scanner(System.in);
		int degId=sc.nextInt();
		String degName=obj.getDegreeName(degId);
		System.out.println(degName);
	}

}
