package sxc.degree;

import java.sql.*;
import java.util.ArrayList;
import sxc.sxcException.NotFoundException;
import sxc.util.*;

public class DegreeDAOImplementation implements DegreeInterface {

	public static DegreeDAOImplementation getInstance() {
		return new DegreeDAOImplementation();
	}

	public void addDegree(String name, int durationInYears) throws Exception {

		Connection con = TestConnect.getConnection();

		Statement stmt = con.createStatement();

		Logger logger = Logger.getInstance();

		String sql = "insert into degree(deg_id,deg_name,no_of_yr) values(degree_seq.nextval,'" + name.toUpperCase()
				+ "'," + durationInYears + ")";

		logger.info(sql);
		stmt.executeUpdate(sql);

		logger.info("Degree Inserted");

		stmt.close();
		con.close();

	}

	public String getDegreeName(int degId) throws Exception {

		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		Logger logger = Logger.getInstance();

		String degName = null;
		ResultSet rs2;

		String sql2 = "select deg_name from degree where deg_id=" + degId + "";
		logger.info(sql2);
		rs2 = stmt.executeQuery(sql2);

		if (rs2.next()) {
			degName = rs2.getString("deg_name");
		} else {
			throw new NotFoundException("Degree doesnot Exist");
		}

		stmt.close();
		con.close();

		return degName;

	}

	public int getDegreeId(String degName) throws Exception {
		Connection con = TestConnect.getConnection();

		Statement stmt = con.createStatement();
		Logger logger = Logger.getInstance();

		String sql1 = "select deg_id from degree where deg_name='" + degName + "'";
		logger.info(sql1);

		int degId = 0;
		ResultSet rs = stmt.executeQuery(sql1);
		if (rs.next()) {
			degId = rs.getInt("deg_id");
		} else {
			throw new NotFoundException("Degree doesnot Exist");
		}

		stmt.close();
		con.close();

		return degId;
	}

	public ArrayList<String> getAllDegree() throws Exception {
		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();
		Logger logger = Logger.getInstance();

		ArrayList<String> list = new ArrayList<>();

		String sql = "select * from degree order by deg_name";

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {

			Degree d = Degree.getInstance();
			d.setName(rs.getString("deg_name"));

			list.add(d.getName());

		}
		stmt.close();
		con.close();

		return list;
	}

}
