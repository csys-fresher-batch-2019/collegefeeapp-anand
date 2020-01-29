package sxc.Semester;

public class TestGetSemesterId {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		SemesterDAOImplementation obj=new SemesterDAOImplementation();
		int yr=2018;
		int semType=0;
		int semId=obj.getSemId(yr, semType);
	System.out.println(semId);
	}

}
