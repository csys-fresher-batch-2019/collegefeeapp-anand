package sxc.Semester;

public interface SemesterInterface {

	void addSemester(Semester s) throws Exception;

	public int getSemId(int yr, int semType) throws Exception;
}
