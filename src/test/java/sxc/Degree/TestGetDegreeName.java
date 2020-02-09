package sxc.degree;

import java.util.Scanner;

import sxc.util.Logger;

public class TestGetDegreeName {

	public static void main(String[] args) throws Exception {
		Logger logger=Logger.getInstance();
		
		DegreeDAOImplementation obj = DegreeDAOImplementation.getInstance();
		Scanner sc= new Scanner(System.in);
		int degId=sc.nextInt();
		String degName=obj.getDegreeName(degId);
		logger.info(degName);
	}

}
