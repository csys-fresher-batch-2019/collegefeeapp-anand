package sxc.FeeCourse;

import java.util.Scanner;

import sxc.Category.CategoryDAOImplementation;
import sxc.Course.CourseDAOImplementation;
import sxc.Degree.DegreeDAOImplementation;
import sxc.Department.DeptDAOImplementation;

public class TestUpdateCourseFee {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String deptName=sc.nextLine().toUpperCase();
		String degName=sc.nextLine().toUpperCase();
		
		DeptDAOImplementation deptObj= new DeptDAOImplementation();
		DegreeDAOImplementation degObj =new DegreeDAOImplementation();
		CourseDAOImplementation courseObj =new CourseDAOImplementation();
		CategoryDAOImplementation catObj=new CategoryDAOImplementation();
		FeeCourseDAOImplementation feeCourseObj=new FeeCourseDAOImplementation();
		
		int deptId=deptObj.getDepartmentId(deptName);
		int degId=degObj.getDegreeId(degName);
		int courseId=courseObj.getCourseId(degId, deptId);
		
		System.out.println("DEPT ID: "+deptId);
		System.out.println("DEGREE ID: "+degId);
		System.out.println("COURSE ID: "+courseId);
		
		String categoryName=sc.nextLine().toUpperCase();
		int feeCategoryId=catObj.getFeeCategoryId(categoryName);
		System.out.println("FEE CATEGORY ID: "+feeCategoryId);
		
		int amount=sc.nextInt();
		
		feeCourseObj.updateCourseFee(courseId, feeCategoryId, amount);
	
	}

}
