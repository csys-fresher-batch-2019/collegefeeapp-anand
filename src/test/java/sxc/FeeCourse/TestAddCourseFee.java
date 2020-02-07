package sxc.FeeCourse;

import java.util.Scanner;

import sxc.Category.Category;
import sxc.Category.CategoryDAOImplementation;
import sxc.Course.CourseDAOImplementation;
import sxc.Degree.DegreeDAOImplementation;
import sxc.Department.DeptDAOImplementation;
import sxc.util.Logger;

public class TestAddCourseFee {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DeptDAOImplementation objDept = DeptDAOImplementation.getInstance();
		DegreeDAOImplementation objDeg = DegreeDAOImplementation.getInstance();
		CourseDAOImplementation objCourse = CourseDAOImplementation.getInstance();
		CategoryDAOImplementation objCategory = CategoryDAOImplementation.getInstance();

		Scanner sc = new Scanner(System.in);
		Logger logger = Logger.getInstance();

		String deptName = sc.nextLine().toUpperCase();
		int deptId = objDept.getDepartmentId(deptName);
		logger.info("DEPT ID: " + deptId);

		String degName = sc.nextLine().toUpperCase();
		int degId = objDeg.getDegreeId(degName);
		logger.info("DEGREE NAME: " + degId);

		int courseId = objCourse.getCourseId(degId, deptId);
		logger.info("COURSE ID: " + courseId);

		String categoryName = sc.nextLine().toUpperCase();
		Category c = new Category();
		c.setName(categoryName);

		int categoryId = objCategory.getFeeCategoryId(c);
		logger.info("FEE CATEGORY ID: " + categoryId);

		int amount = sc.nextInt();

		FeeCourseDAOImplementation obj = FeeCourseDAOImplementation.getInstance();

		obj.addCourseFee(courseId, categoryId, amount);

	}

}
