package sxc.FeeCourse;

import java.util.Scanner;

import sxc.Category.CategoryDAOImplementation;
import sxc.Course.CourseDAOImplementation;
import sxc.Degree.DegreeDAOImplementation;
import sxc.Department.DeptDAOImplementation;
import sxc.util.Logger;


public class TestAddCourseFee {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DeptDAOImplementation objDept=new DeptDAOImplementation();
		DegreeDAOImplementation objDeg=new DegreeDAOImplementation();
		CourseDAOImplementation objCourse=new CourseDAOImplementation();
		CategoryDAOImplementation objCategory=new CategoryDAOImplementation();
		
		Scanner sc=new Scanner(System.in);
		Logger logger=Logger.getInstance();
		
		String deptName=sc.nextLine().toUpperCase();
		int deptId=objDept.getDepartmentId(deptName);
		logger.info("DEPT ID: "+deptId);
		
		String degName=sc.nextLine().toUpperCase();
		int degId=objDeg.getDegreeId(degName);
		logger.info("DEGREE NAME: "+degId);
		
		int courseId=objCourse.getCourseId(degId, deptId);
		logger.info("COURSE ID: "+courseId);
		
		String categoryName=sc.nextLine().toUpperCase();
		
		int categoryId=objCategory.getFeeCategoryId(categoryName);		
		logger.info("FEE CATEGORY ID: "+categoryId);
		
		int amount=sc.nextInt();
		
		FeeCourseDAOImplementation obj = new FeeCourseDAOImplementation();
		
		obj.addCourseFee( courseId, categoryId, amount);

	}

}
