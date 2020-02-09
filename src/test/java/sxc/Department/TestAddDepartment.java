package sxc.department;

import java.util.Scanner;

public class TestAddDepartment {

	public static void main(String[] args) throws Exception {
		DeptDAOImplementation obj=DeptDAOImplementation.getInstance();
		Scanner sc=new Scanner(System.in);
		String deptName=(sc.next()).toUpperCase();
		obj.addDepartment(deptName);
	}

}
