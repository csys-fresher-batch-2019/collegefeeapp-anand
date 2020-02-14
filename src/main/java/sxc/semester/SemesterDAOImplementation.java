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
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			String sql = "insert into semester(sem_id,sem_type,acc_yr_begin) values(semester_seq.nextval,"
					+ s.getsemType() + "," + s.getaccYear() + ")";

			stmt.executeUpdate(sql);

			logger.info("Semester Generated");

		}
	}

	public int getSemId(Semester s) throws Exception {

		Logger logger = Logger.getInstance();
		String sql = "select sem_id from semester where acc_yr_begin=" + s.getaccYear() + " and sem_type="
				+ s.getsemType() + " ";

		logger.info(sql);
		int semId = 0;

		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {

			try (ResultSet rs = stmt.executeQuery(sql);) {
				semId = rs.getInt("sem_id");
			} catch (Exception e) {
				throw new NotFoundException("INVALID SEMESTER");
			}
			return semId;
		}
	}
}
