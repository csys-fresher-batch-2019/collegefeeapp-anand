package sxc.Degree;

import java.util.ArrayList;

import sxc.util.Logger;

public class TestGetAllDegree {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getInstance();
		
		DegreeDAOImplementation obj=new DegreeDAOImplementation();
		ArrayList<Degree> list=obj.getAllDegree();
		logger.info(list.toString());
	}

}
