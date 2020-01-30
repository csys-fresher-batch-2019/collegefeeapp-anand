package sxc.FeeCourse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import sxc.util.Logger;
import sxc.util.TestConnect;

public class FeeCourseDAOImplementation implements FeeCourseInterface {

	public void addCourseFee(int courseId, int feeCategoryId, int amount) throws Exception {
		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();
		Logger logger=Logger.getInstance();
		
		String sql = "insert into course_fee(course_fee_id,course_id,fee_category_id,amount) values(course_fee_seq.nextval,'"
				+ courseId + "','" + feeCategoryId + "','" + amount + "')";
		stmt.executeUpdate(sql);

		logger.info("Course Fee added successfully");
	}

	public void updateCourseFee(int courseId, int feeCategoryId, int amount) throws Exception {
		// TODO Auto-generated method stub
		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();
		Logger logger=Logger.getInstance();
		
		String sql = "update course_fee set amount=" + amount + " where course_id=" + courseId + " and fee_category_id="
				+ feeCategoryId;
		int rows = stmt.executeUpdate(sql);
		if (rows > 0) {
			logger.info("Course Fee Updated");
		}
		else
		{
			throw new Exception("Fee Category for the selected Course does not exist");
		}
	}

	public int getCourseFeeId(int courseId, int feeCategoryId) throws Exception {
		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();
		Logger logger=Logger.getInstance();
		int courseFeeId = 0;

		String sql = "select course_fee_id from course_fee where course_id=" + courseId + " and fee_category_id="
				+ feeCategoryId + "";
		logger.info(sql);

		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			courseFeeId = rs.getInt("course_fee_id");
		}
		return courseFeeId;
	}

	public int getCourseFeeAmount(int feeCourseId) throws Exception {

		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		int feeCourseAmount = 0;

		String sql = "select amount from course_fee where course_fee_id=" + feeCourseId + "";
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			feeCourseAmount = rs.getInt("amount");
		}

		return feeCourseAmount;

	}

}
