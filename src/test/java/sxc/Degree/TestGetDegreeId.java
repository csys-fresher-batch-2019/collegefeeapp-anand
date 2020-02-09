package sxc.degree;

import java.util.Scanner;

import sxc.util.Logger;

public class TestGetDegreeId {

	public static void main(String[] args) throws Exception {
		Logger logger=Logger.getInstance();
		DegreeDAOImplementation obj=DegreeDAOImplementation.getInstance();
		Scanner sc= new Scanner(System.in);
		String degName=(sc.next()).toUpperCase();
		int degId=obj.getDegreeId(degName);
		logger.info(degId);
	}

}

