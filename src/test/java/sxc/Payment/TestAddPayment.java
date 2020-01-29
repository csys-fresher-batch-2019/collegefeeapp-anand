package sxc.Payment;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import sxc.Category.CategoryDAOImplementation;
import sxc.Course.CourseDAOImplementation;
import sxc.Degree.DegreeDAOImplementation;
import sxc.Department.DeptDAOImplementation;
import sxc.FeeCourse.FeeCourseDAOImplementation;
import sxc.Semester.SemesterDAOImplementation;
import sxc.Student.StudentDAOImplementation;

public class TestAddPayment 
{

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		
//		DeptDAOImplementation deptObj=new DeptDAOImplementation();
//		DegreeDAOImplementation degObj=new DegreeDAOImplementation();
		CourseDAOImplementation courseObj=new CourseDAOImplementation();
		CategoryDAOImplementation catObj=new CategoryDAOImplementation();
		SemesterDAOImplementation semObj=new SemesterDAOImplementation();
		StudentDAOImplementation stdObj=new StudentDAOImplementation();
		FeeCourseDAOImplementation feeCourseObj=new FeeCourseDAOImplementation();
		
//		String degName=sc.nextLine().toUpperCase();
//		String deptName=sc.nextLine().toUpperCase();
//		int deptId=deptObj.getDepartmentId(deptName);
//		int degId=degObj.getDegreeId(degName);
//		int courseId=courseObj.getCourseId(degId, deptId);
//		System.out.println("DEPARTEMENT ID: "+deptId);
//		System.out.println("DEGREE ID: "+degId);

		String regno=sc.nextLine().toUpperCase();

		int courseId=stdObj.getCourseIdByRegno(regno);
		
		System.out.println("COURSE ID: "+courseId);
		
		String categoryName=sc.nextLine().toUpperCase();
		int feeCategoryId=catObj.getFeeCategoryId(categoryName);
		System.out.println("CATEGORY ID: "+feeCategoryId);	
		
		int feeCourseId=feeCourseObj.getCourseFeeId(courseId, feeCategoryId);
		System.out.println("COURSE FEE ID: "+feeCourseId);
		
		int payable=feeCourseObj.getCourseFeeAmount(feeCourseId);
		System.out.println("PAYABLE AMOUNT: "+payable);		
		
		int yr=sc.nextInt();
		
		String sem=sc.next().toUpperCase();
		int semType=2;
		
		if(sem.equals("ODD"))
		{
			semType=1;
		}
		else if(sem.equals("EVEN"))
		{
			semType=0;
		}
		else {
			throw new Exception("INVALID INPUT");
		}
		
		int semId=semObj.getSemId(yr,semType);
		System.out.println("SEM ID:"+semId);
		
		PaymentDAOImplementation obj=new PaymentDAOImplementation();
		obj.addPayment(regno, feeCourseId, semId, payable);
		
	}

}
