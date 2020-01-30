package sxc.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import sxc.SXCException.NotFoundException;
import sxc.util.Logger;
import sxc.util.TestConnect;

public class StudentDAOImplementation implements Student {

	public void addStudent(String regno, String name, int courseId) throws Exception {

		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();
		Logger logger=Logger.getInstance();
		
		String sql = "insert into student(std_id,std_name,course_id) values('" + regno + "','" + name + "'," + courseId
				+ ")";
		logger.info(sql);
		stmt.executeUpdate(sql);

		logger.info("Student Details inserted");

		stmt.close();
		con.close();
	}

	public void updateStudentName(String regno, String name) throws Exception {
		// TODO Auto-generated method stub

		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();
		Logger logger=Logger.getInstance();
		
		String sql = "update student set std_name='" + name + "' where std_id='" + regno + "'";
		int row = stmt.executeUpdate(sql);
		if (row > 0) {
			logger.info("Student Name Updated");
		}
		else
		{
			throw new NotFoundException("No Student record found");
		}
		stmt.close();
		con.close();
	}

	public void deleteStudent(String regno) throws Exception {
		// TODO Auto-generated method stub
		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		Logger logger=Logger.getInstance();
		
		String sql = "update student set stud_active=0 where std_id='" + regno + "'";
		int row = stmt.executeUpdate(sql);
		if (row > 0) {
			logger.info("Student Deleted");
		}
		else
		{
			throw new NotFoundException("No Student record found");
		}
		stmt.close();
		con.close();
	}

	public ArrayList<Stud_Class> getAllActiveStudents() throws Exception {
		// TODO Auto-generated method stub
		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		String sql = "select * from student where stud_active=1";
		ResultSet rs = stmt.executeQuery(sql);

		ArrayList<Stud_Class> list = new ArrayList<Stud_Class>();

		while (rs.next()) {
			Stud_Class s = new Stud_Class();
			s.regno = rs.getString("std_id");
			s.name = rs.getString("std_name");
			s.course_id = rs.getInt("course_id");
			s.stud_active = rs.getInt("stud_active");

			list.add(s);
		}
		stmt.close();
		con.close();

		return list;
	}

	public ArrayList<Stud_Class> getActiveStudentsByCourse(int course_id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		String sql = "select * from student where course_id=" + course_id + " and stud_active=1";
		ResultSet rs = stmt.executeQuery(sql);

		ArrayList<Stud_Class> list = new ArrayList<Stud_Class>();

		while (rs.next()) {
			Stud_Class s = new Stud_Class();
			s.regno = rs.getString("std_id");
			s.name = rs.getString("std_name");
			s.course_id = rs.getInt("course_id");
			s.stud_active = rs.getInt("stud_active");

			list.add(s);
		}

		stmt.close();
		con.close();

		return list;
	}

	public int getCourseIdByRegno(String regno) throws Exception {

		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		int course_id = 0;

		String sql = "select course_id from student where std_id='" + regno + "'";

		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			course_id = rs.getInt("course_id");
		} else {
			throw new NotFoundException("No Student record found");
		}

		return course_id;
	}

}
