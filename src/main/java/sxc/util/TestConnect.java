package sxc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sxc.sxcException.DbException;

public class TestConnect {

	public static Connection getConnection() throws DbException, SQLException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			Logger.getInstance().error("Class Not Found");
		}
		return DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:XE", "system", "oracle");
	}

}