package sxc.Student;

import java.util.ArrayList;

public interface Student
{
	void addStudent(String regno,String name,int courseId) throws Exception;
	void updateStudentName(String regno,String name) throws Exception;
	void deleteStudent(String regno) throws Exception;
	ArrayList<Stud_Class> getAllActiveStudents() throws Exception;
	ArrayList<Stud_Class> getActiveStudentsByCourse(int course_id) throws Exception;
	public int getCourseIdByRegno(String regno) throws Exception;	
}
