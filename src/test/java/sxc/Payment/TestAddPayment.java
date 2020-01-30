package sxc.Payment;

import java.util.Scanner;

import sxc.Category.CategoryDAOImplementation;
import sxc.Course.CourseDAOImplementation;
import sxc.FeeCourse.FeeCourseDAOImplementation;
import sxc.SXCException.NotFoundException;
import sxc.Semester.SemesterDAOImplementation;
import sxc.Student.StudentDAOImplementation;
import sxc.util.Logger;

public class TestAddPayment 
{

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
				
		CategoryDAOImplementation catObj=new CategoryDAOImplementation();
		SemesterDAOImplementation semObj=new SemesterDAOImplementation();
		StudentDAOImplementation stdObj=new StudentDAOImplementation();
		FeeCourseDAOImplementation feeCourseObj=new FeeCourseDAOImplementation();
		Logger logger=Logger.getInstance();
		
//		String degName=sc.nextLine().toUpperCase();
//		String deptName=sc.nextLine().toUpperCase();
//		int deptId=deptObj.getDepartmentId(deptName);
//		int degId=degObj.getDegreeId(degName);
//		int courseId=courseObj.getCourseId(degId, deptId);
//		System.out.println("DEPARTEMENT ID: "+deptId);
//		System.out.println("DEGREE ID: "+degId);

		String regno=sc.nextLine().toUpperCase();

		int courseId=stdObj.getCourseIdByRegno(regno);
		
		logger.info("COURSE ID: "+courseId);
		
		String categoryName=sc.nextLine().toUpperCase();
		int feeCategoryId=catObj.getFeeCategoryId(categoryName);
		logger.info("CATEGORY ID: "+feeCategoryId);	
		
		int feeCourseId=feeCourseObj.getCourseFeeId(courseId, feeCategoryId);
		logger.info("COURSE FEE ID: "+feeCourseId);
		
		int payable=feeCourseObj.getCourseFeeAmount(feeCourseId);
		logger.info("PAYABLE AMOUNT: "+payable);		
		
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
			throw new NotFoundException("INVALID INPUT");
		}
		
		int semId=semObj.getSemId(yr,semType);
		logger.info("SEM ID:"+semId);
		
		PaymentDAOImplementation obj=new PaymentDAOImplementation();
		obj.addPayment(regno, feeCourseId, semId, payable);
		
	}

}
