package sxc.Semester;

import sxc.Semester.SemesterDAOImplementation;

public class TestAddSemester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		SemesterDAOImplementation obj = SemesterDAOImplementation.getInstance();

		Semester s = new Semester();
		s.setaccYear(2002);
		s.setsemType(1);

		obj.addSemester(s);

	}

}
