package sxc.Semester;

import sxc.util.Logger;

public class TestGetSemesterId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Logger logger = Logger.getInstance();
		SemesterDAOImplementation obj = new SemesterDAOImplementation();
		int yr = 2018;
		int semType = 0;
		int semId = obj.getSemId(yr, semType);
		logger.info(semId);
	}

}