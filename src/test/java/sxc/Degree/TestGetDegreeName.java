package sxc.Degree;

import java.util.Scanner;

import sxc.util.Logger;

public class TestGetDegreeName {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Logger logger=new Logger();
		
		DegreeDAOImplementation obj = new DegreeDAOImplementation();
		Scanner sc= new Scanner(System.in);
		int degId=sc.nextInt();
		String degName=obj.getDegreeName(degId);
		logger.info(degName);
	}

}
