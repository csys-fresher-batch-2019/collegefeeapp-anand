package sxc.payment;

import java.util.Scanner;

import sxc.category.Category;
import sxc.category.CategoryDAOImplementation;
import sxc.feeCourse.FeeCourseDAOImplementation;
import sxc.sxcException.InvalidInputException;
import sxc.semester.Semester;
import sxc.semester.SemesterDAOImplementation;
import sxc.student.Stud_Class;
import sxc.student.StudentDAOImplementation;
import sxc.util.Logger;

public class TestAddPayment 
{

	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
				
		CategoryDAOImplementation catObj= CategoryDAOImplementation.getInstance();
		SemesterDAOImplementation semObj= SemesterDAOImplementation.getInstance();
		StudentDAOImplementation stdObj= StudentDAOImplementation.getInstance();
		FeeCourseDAOImplementation feeCourseObj=FeeCourseDAOImplementation.getInstance();
		Logger logger=Logger.getInstance();
		
		String regno=sc.nextLine().toUpperCase();

		Stud_Class s=new Stud_Class();
		s.setRegno(regno);
		int courseId=stdObj.getCourseIdByRegno(s);
		
		logger.info("COURSE ID: "+courseId);
		
		String categoryName=sc.nextLine().toUpperCase();
		
		Category c=new Category();
		c.setName(categoryName);
		
		int feeCategoryId=catObj.getFeeCategoryId(c);
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
			throw new InvalidInputException("INVALID INPUT");
		}
		
		Semester s1=new Semester();
		s1.setaccYear(yr);
		s1.setsemType(semType);
		
		int semId=semObj.getSemId(s1);
		logger.info("SEM ID:"+semId);
		
		PaymentDAOImplementation obj= PaymentDAOImplementation.getInstance();
	
		PaymentDetail p=new PaymentDetail();
		
		p.setRegno(regno);
		p.setFeeCourseId(feeCourseId);
		p.setSemId(semId);
		p.setAmount(payable);
		
		obj.addPayment(p);
		
	}

}
