package sxc.Student;

import java.util.ArrayList;

public class TestGetAllActiveStudents {
	
	public static void main(String[] args) throws Exception {
		
		StudentDAOImplementation obj=new StudentDAOImplementation();
		ArrayList<Stud_Class> list=obj.getAllActiveStudents();
		System.out.println(list);
	}

}
