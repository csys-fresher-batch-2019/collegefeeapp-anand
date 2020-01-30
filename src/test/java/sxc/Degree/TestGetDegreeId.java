package sxc.Degree;

import java.util.Scanner;

import sxc.util.Logger;

public class TestGetDegreeId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Logger logger=new Logger();
		DegreeDAOImplementation obj=new DegreeDAOImplementation();
		Scanner sc= new Scanner(System.in);
		String degName=(sc.next()).toUpperCase();
		int degId=obj.getDegreeId(degName);
		logger.info(degId);
	}

}
