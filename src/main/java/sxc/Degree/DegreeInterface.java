package sxc.Degree;

import java.util.ArrayList;

public interface DegreeInterface {

	void addDegree(String name,int durationInYears) throws Exception;
	int getDegreeId(String degreeName) throws Exception;
	String getDegreeName(int degreeId) throws Exception;
	ArrayList<String> getAllDegree() throws Exception;
}
