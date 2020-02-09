package sxc.semester;

import sxc.semester.SemesterDAOImplementation;

public class TestAddSemester {

	public static void main(String[] args) throws Exception {
		SemesterDAOImplementation obj = SemesterDAOImplementation.getInstance();
		Semester s = Semester.getInstance();
		s.setaccYear(2002);
		s.setsemType(1);

		obj.addSemester(s);

	}

}
