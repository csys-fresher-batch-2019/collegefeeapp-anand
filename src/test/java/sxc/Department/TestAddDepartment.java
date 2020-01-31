package sxc.Department;

import java.util.Scanner;

public class TestAddDepartment {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DeptDAOImplementation obj=DeptDAOImplementation.getInstance();
		Scanner sc=new Scanner(System.in);
		String deptName=(sc.next()).toUpperCase();
		obj.addDepartment(deptName);
	}

}
