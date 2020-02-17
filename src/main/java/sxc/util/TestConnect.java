package sxc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class TestConnect {

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		} catch (ClassNotFoundException e) {
			Logger.getInstance().error("Class Not Found");
		}
		return con;
	}

	public static Jdbi getJdbi() {
		Jdbi jdbi = null;
		try {
			Connection connection = TestConnect.getConnection();
			jdbi = Jdbi.create(connection);
			jdbi.installPlugin(new SqlObjectPlugin());
		} catch (SQLException e) {
			Logger.getInstance().error("Class Not Found");
		}
		return jdbi;
	}

}