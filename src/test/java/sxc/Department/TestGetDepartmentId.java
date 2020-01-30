package sxc.Department;

import java.util.Scanner;

import sxc.util.Logger;

public class TestGetDepartmentId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getInstance();
		DeptDAOImplementation obj=new DeptDAOImplementation();
		Scanner sc=new Scanner(System.in);
		String deptName=(sc.next()).toUpperCase();
		int dept_id=obj.getDepartmentId(deptName);
		logger.info(dept_id);
	}

}
