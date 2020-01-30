package sxc.Semester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sxc.util.Logger;

public class SemesterDAOImplementation implements SemesterInterface {

	public void addSemester(Semester s) throws Exception {
		Connection con = getConnection();

		Statement stmt = con.createStatement();
		Logger logger=new Logger();
		
		String sql = "insert into semester(sem_id,sem_type,acc_yr_begin) values(semester_seq.nextval," + s.getsemType()
				+ "," + s.getaccYear() + ")";

		stmt.executeUpdate(sql);

		logger.info("Semester Generated");

		stmt.close();
		con.close();

	}

	public int getSemId(int yr, int semType) throws Exception {
		Connection con = getConnection();

		Statement stmt = con.createStatement();

		Logger logger=new Logger();
		String sql = "select sem_id from semester where acc_yr_begin=" + yr + " and sem_type=" + semType + " ";

		logger.info(sql);

		int semId = 0;

		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			semId = rs.getInt("sem_id");
		} else {
			throw new Exception("Invalid semester");
		}

		return semId;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.201:1521:XE", "system", "oracle");
		return con;

	}

}
