package sxc.Degree;

import java.util.ArrayList;

public class TestGetAllDegree {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DegreeDAOImplementation obj=new DegreeDAOImplementation();
		ArrayList<Degree> list=obj.getAllDegree();
		System.out.println(list);
	}

}
