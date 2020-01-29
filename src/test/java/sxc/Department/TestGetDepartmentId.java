package sxc.Department;

import java.util.Scanner;

public class TestGetDepartmentId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DeptDAOImplementation obj=new DeptDAOImplementation();
		Scanner sc=new Scanner(System.in);
		String deptName=(sc.next()).toUpperCase();
		int dept_id=obj.getDepartmentId(deptName);
		System.out.println(dept_id);
	}

}
