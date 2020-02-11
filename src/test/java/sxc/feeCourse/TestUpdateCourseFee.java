package sxc.feeCourse;

import java.util.Scanner;

import sxc.category.Category;
import sxc.category.CategoryDAOImplementation;
import sxc.course.CourseDAOImplementation;
import sxc.degree.DegreeDAOImplementation;
import sxc.department.DeptDAOImplementation;
import sxc.util.Logger;

public class TestUpdateCourseFee {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		Logger logger = Logger.getInstance();

		String degName = sc.nextLine().toUpperCase();
		String deptName = sc.nextLine().toUpperCase();

		DeptDAOImplementation deptObj = DeptDAOImplementation.getInstance();
		DegreeDAOImplementation degObj = DegreeDAOImplementation.getInstance();
		CourseDAOImplementation courseObj = CourseDAOImplementation.getInstance();
		CategoryDAOImplementation catObj = CategoryDAOImplementation.getInstance();
		FeeCourseDAOImplementation feeCourseObj = FeeCourseDAOImplementation.getInstance();

		int deptId = deptObj.getDepartmentId(deptName);
		int degId = degObj.getDegreeId(degName);
		int courseId = courseObj.getCourseId(degId, deptId);

		logger.info("DEPT ID: " + deptId);
		logger.info("DEGREE ID: " + degId);
		logger.info("COURSE ID: " + courseId);

		String categoryName = sc.nextLine().toUpperCase();

		Category c = Category.getInstance();
		c.setName(categoryName);
		int feeCategoryId = catObj.getFeeCategoryId(c);
		logger.info("FEE CATEGORY ID: " + feeCategoryId);

		int amount = sc.nextInt();

		feeCourseObj.updateCourseFee(courseId, feeCategoryId, amount);

	}

}
