package sxc.Degree;

import java.sql.*;
import sxc.util.*;

import java.util.ArrayList;
import java.util.Scanner;

public class DegreeDAOImplementation implements DegreeInterface {

	public void addDegree(String name, int durationInYears) throws Exception {

		Connection con = getConnection();

		Statement stmt = con.createStatement();

		Logger logger=new Logger();
		
		String sql = "insert into degree(deg_id,deg_name,no_of_yr) values(degree_seq.nextval,'" + name + "','"
				+ durationInYears + "')";

		logger.info(sql);

		int rows = stmt.executeUpdate(sql);

		logger.info("Degree Inserted");

		stmt.close();
		con.close();

	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.201:1521:XE", "system", "oracle");
		return con;
	}

	public String getDegreeName(int degId) throws Exception {

		Connection con = getConnection();
		Statement stmt = con.createStatement();
		
		Logger logger=new Logger();
		
		String degName = null;
		ResultSet rs2;

		Scanner sc = new Scanner(System.in);
		int deg_id = sc.nextInt();

		String sql2 = "select deg_name from degree where deg_id=" + deg_id + "";
		logger.info(sql2);
		rs2 = stmt.executeQuery(sql2);

		if (rs2.next()) {
			degName = rs2.getString("deg_name");
		} else {
			throw new Exception("Degree doesnot Exist");
		}

		stmt.close();
		con.close();

		return degName;

	}

	public int getDegreeId(String degName) throws Exception {
		Connection con = getConnection();

		Statement stmt = con.createStatement();
		Logger logger=new Logger();
		
		String sql1 = "select deg_id from degree where deg_name='" + degName + "'";
		logger.info(sql1);

		int degId = 0;
		ResultSet rs = stmt.executeQuery(sql1);
		if (rs.next()) {
			degId = rs.getInt("deg_id");
		} else {
			throw new Exception("Degree doesnot Exist");
		}

		stmt.close();
		con.close();

		return degId;
	}

	public ArrayList<Degree> getAllDegree() throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		Logger logger=new Logger();
		
		ArrayList<Degree> list = new ArrayList();

		String sql = "select * from degree";
		logger.info(sql);

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("deg_id");
			String name = rs.getString("deg_name");

			Degree d = new Degree();
			d.id = id;
			d.name = name;

			list.add(d);

		}
		stmt.close();
		con.close();

		return list;
	}

}
