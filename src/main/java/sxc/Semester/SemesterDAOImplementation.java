package sxc.semester;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import sxc.sxcException.NotFoundException;
import sxc.util.Logger;
import sxc.util.TestConnect;

public class SemesterDAOImplementation implements SemesterInterface {

	public static SemesterDAOImplementation getInstance() {
		return new SemesterDAOImplementation();
	}

	public void addSemester(Semester s) throws Exception {

		Logger logger = Logger.getInstance();

		String sql = "insert into semester(sem_id,sem_type,acc_yr_begin) values(semester_seq.nextval," + s.getsemType()
				+ "," + s.getaccYear() + ")";

		Connection con = TestConnect.getConnection();

		Statement stmt = con.createStatement();

		stmt.executeUpdate(sql);

		logger.info("Semester Generated");

		con.close();

	}

	public int getSemId(Semester s) throws Exception {

		Logger logger = Logger.getInstance();
		String sql = "select sem_id from semester where acc_yr_begin=" + s.getaccYear() + " and sem_type="
				+ s.getsemType() + " ";

		logger.info(sql);

		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		int semId = 0;

		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			semId = rs.getInt("sem_id");
		} else {
			throw new NotFoundException("INVALID SEMESTER");
		}
		return semId;
	}
}
