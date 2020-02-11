package sxc.degree;

import java.util.ArrayList;

import sxc.util.Logger;

public class TestGetAllDegree {

	public static void main(String[] args) throws Exception {
		Logger logger=Logger.getInstance();
		
		DegreeDAOImplementation obj= DegreeDAOImplementation.getInstance();
		ArrayList<String> list=obj.getAllDegree();
		logger.info(list.toString());
	}

}
