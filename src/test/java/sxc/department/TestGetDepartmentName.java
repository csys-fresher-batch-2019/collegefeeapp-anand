package sxc.department;

import java.util.Scanner;
import sxc.util.Logger;

public class TestGetDepartmentName {

	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getInstance();
		DeptDAOImplementation obj = DeptDAOImplementation.getInstance();
		Scanner sc = new Scanner(System.in);
		int deptId = sc.nextInt();
		String dept_name = obj.getDepartmentName(deptId);
		logger.info(dept_name);
	}
}
