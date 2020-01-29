package sxc.Department;

import java.util.Scanner;

public class TestGetDepartmentName {

	public static void main(String[] args) throws Exception {
		DeptDAOImplementation obj=new DeptDAOImplementation();
		Scanner sc=new Scanner(System.in);
		int deptId=sc.nextInt();
		String dept_name=obj.getDepartmentName(deptId);	
		System.out.println(dept_name);
	}
}
