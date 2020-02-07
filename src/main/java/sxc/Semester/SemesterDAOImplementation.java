package sxc.Semester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sxc.SXCException.NotFoundException;
import sxc.util.Logger;
import sxc.util.TestConnect;

public class SemesterDAOImplementation implements SemesterInterface {

	public static SemesterDAOImplementation getInstance() {
		return new SemesterDAOImplementation();
	}

	public void addSemester(Semester s) throws Exception {
		Connection con = TestConnect.getConnection();

		Logger logger = Logger.getInstance();

		String sql = "insert into semester(sem_id,sem_type,acc_yr_begin) values(semester_seq.nextval," + s.getsemType()
				+ "," + s.getaccYear() + ")";

		Statement stmt = con.createStatement();

		stmt.executeUpdate(sql);

		logger.info("Semester Generated");

		con.close();

	}

	public int getSemId(Semester s) throws Exception {
		Connection con = TestConnect.getConnection();

		Statement stmt = con.createStatement();

		Logger logger = Logger.getInstance();
		String sql = "select sem_id from semester where acc_yr_begin=" + s.getaccYear() + " and sem_type="
				+ s.getsemType() + " ";

		logger.info(sql);

		int semId = 0;

		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			semId = rs.getInt("sem_id");
		} else {
			throw new NotFoundException("Invalid semester");
		}

		return semId;
	}

}
