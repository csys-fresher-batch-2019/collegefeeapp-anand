package sxc.student;

import java.util.ArrayList;

import sxc.util.Logger;

public class TestGetAllActiveStudents {

	public static void main(String[] args) throws Exception {

		Logger logger = Logger.getInstance();

		StudentDAOImplementation obj = StudentDAOImplementation.getInstance();
		ArrayList<Stud_Class> list = obj.getAllActiveStudents();
		logger.info(list);
	}

}
