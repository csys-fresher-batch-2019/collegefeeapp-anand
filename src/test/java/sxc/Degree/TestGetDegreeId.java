package sxc.Degree;

import java.util.Scanner;

public class TestGetDegreeId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DegreeDAOImplementation obj=new DegreeDAOImplementation();
		Scanner sc= new Scanner(System.in);
		String degName=(sc.next()).toUpperCase();
		int degId=obj.getDegreeId(degName);
		System.out.println(degId);
	}

}
