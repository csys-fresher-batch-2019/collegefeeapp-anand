package sxc.semester;

import sxc.util.Logger;

public class TestGetSemesterId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Logger logger = Logger.getInstance();
		SemesterDAOImplementation obj = SemesterDAOImplementation.getInstance();
		int yr = 2018;
		int semType = 0;

		Semester s = new Semester();
		s.setaccYear(yr);
		s.setsemType(semType);

		int semId = obj.getSemId(s);
		logger.info(semId);
	}

}
