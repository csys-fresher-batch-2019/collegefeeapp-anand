package sxc.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sxc.SXCException.NotFoundException;
import sxc.util.Logger;

public class CourseDAOImplementation implements CourseInterface {

	public void addCourse(int deptId, int degId) throws Exception {
		Connection con = getConnection();

		Statement stmt = con.createStatement();
		Logger logger=new Logger();
		
		String sql = "insert into course(course_id,dept_id,deg_id) values(course_seq.nextVal," + deptId + "," + degId
				+ ")";

		stmt.executeUpdate(sql);

		logger.info(sql);
		logger.info("Course Added");

		stmt.close();
		con.close();

	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.201:1521:XE", "system", "oracle");
		return con;
	}

	public int getCourseId(int degId, int deptId) throws Exception {
		Connection con = getConnection();

		Statement stmt = con.createStatement();

		Logger logger=new Logger();
		String sql = "select course_id from course where deg_id= " + degId + " and dept_id=" + deptId + "";
		ResultSet rs = stmt.executeQuery(sql);
		int result = 0;
		if (rs.next()) {
			result = rs.getInt("course_id");
		} else {
			throw new NotFoundException("Course Does not Exist");
		}

		stmt.close();
		con.close();

		return result;
	}

	public String getCourseName(int courseId) throws Exception {
		Connection con = getConnection();

		Statement stmt = con.createStatement();
		Logger logger=new Logger();
		String degreeName = "";
		String deptName = "";

		String sql1 = "select dept_name from department where dept_id=(select dept_id from course where course_id="
				+ courseId + ")";
		System.out.println(sql1);
		ResultSet rs1 = stmt.executeQuery(sql1);

		if (rs1.next()) {
			deptName = rs1.getString("dept_name");
		}

		String sql2 = "select deg_name from degree where deg_id=(select deg_id from course where course_id=" + courseId
				+ ")";
		logger.info(sql2);
		ResultSet rs2 = stmt.executeQuery(sql2);

		if (rs2.next()) {
			degreeName = rs2.getString("deg_name");
		}

		stmt.close();
		con.close();

		if (degreeName.equals("") || deptName.equals("")) {
			throw new NotFoundException("Course doesnot Exist");
		}

		String courseName = degreeName + " (" + deptName + ")";
		return courseName;

	}

	public void deleteCourse(int courseId) throws Exception {
		Connection con = getConnection();

		Statement stmt = con.createStatement();
		Logger logger=new Logger();
		
		String sql = "update course set course_active=0 where course_id=" + courseId + "";
		int rows = stmt.executeUpdate(sql);
		if (rows > 0) {
			logger.info("Course Deleted");
		}
		else
		{
			throw new NotFoundException("Course Not Found");
		}
		stmt.close();
		con.close();

	}

	public ArrayList<Course> getAllCourse() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Course> list = new ArrayList<Course>();

		Connection con = getConnection();
		Statement stmt = con.createStatement();

		String sql = "select * from course";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Course c = new Course();
			c.courseId = rs.getInt("course_id");
			c.degreeId = rs.getInt("deg_id");
			c.deptId = rs.getInt("dept_id");
			c.status = rs.getInt("course_active");

			list.add(c);
		}
		
		return list;
	}
}
