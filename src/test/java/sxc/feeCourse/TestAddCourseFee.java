package sxc.feeCourse;

import java.util.Scanner;

import sxc.category.Category;
import sxc.category.CategoryDAOImplementation;
import sxc.course.CourseDAOImplementation;
import sxc.degree.DegreeDAOImplementation;
import sxc.department.DeptDAOImplementation;
import sxc.util.Logger;

public class TestAddCourseFee {

	public static void main(String[] args) throws Exception {

		DeptDAOImplementation objDept = DeptDAOImplementation.getInstance();
		DegreeDAOImplementation objDeg = DegreeDAOImplementation.getInstance();
		CourseDAOImplementation objCourse = CourseDAOImplementation.getInstance();
		CategoryDAOImplementation objCategory = CategoryDAOImplementation.getInstance();

		Scanner sc = new Scanner(System.in);
		Logger logger = Logger.getInstance();

		String degName = sc.nextLine().toUpperCase();
		int degId = objDeg.getDegreeId(degName);
		logger.info("DEGREE ID: " + degId);

		String deptName = sc.nextLine().toUpperCase();
		int deptId = objDept.getDepartmentId(deptName);
		logger.info("DEPT ID: " + deptId);

		int courseId = objCourse.getCourseId(degId, deptId);
		logger.info("COURSE ID: " + courseId);

		String categoryName = sc.nextLine().toUpperCase();
		Category c = Category.getInstance();
		c.setName(categoryName);
		int categoryId = objCategory.getFeeCategoryId(c);
		logger.info("FEE CATEGORY ID: " + categoryId);

		int amount = sc.nextInt();

		FeeCourseDAOImplementation obj = FeeCourseDAOImplementation.getInstance();

		obj.addCourseFee(courseId, categoryId, amount);

	}

}
