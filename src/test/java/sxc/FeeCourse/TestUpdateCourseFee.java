package sxc.FeeCourse;

import java.util.Scanner;

import sxc.Category.CategoryDAOImplementation;
import sxc.Course.CourseDAOImplementation;
import sxc.Degree.DegreeDAOImplementation;
import sxc.Department.DeptDAOImplementation;
import sxc.util.Logger;

public class TestUpdateCourseFee {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		Logger logger=Logger.getInstance();
		
		String deptName=sc.nextLine().toUpperCase();
		String degName=sc.nextLine().toUpperCase();
		
		DeptDAOImplementation deptObj= DeptDAOImplementation.getInstance();
		DegreeDAOImplementation degObj = DegreeDAOImplementation.getInstance();
		CourseDAOImplementation courseObj =CourseDAOImplementation.getInstance();
		CategoryDAOImplementation catObj=CategoryDAOImplementation.getInstance();
		FeeCourseDAOImplementation feeCourseObj=FeeCourseDAOImplementation.getInstance();
		
		int deptId=deptObj.getDepartmentId(deptName);
		int degId=degObj.getDegreeId(degName);
		int courseId=courseObj.getCourseId(degId, deptId);
		
		logger.info("DEPT ID: "+deptId);
		logger.info("DEGREE ID: "+degId);
		logger.info("COURSE ID: "+courseId);
		
		String categoryName=sc.nextLine().toUpperCase();
		int feeCategoryId=catObj.getFeeCategoryId(categoryName);
		logger.info("FEE CATEGORY ID: "+feeCategoryId);
		
		int amount=sc.nextInt();
		
		feeCourseObj.updateCourseFee(courseId, feeCategoryId, amount);
	
	}

}
