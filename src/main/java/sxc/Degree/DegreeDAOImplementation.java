package sxc.Degree;

import java.sql.*;

import sxc.SXCException.NotFoundException;
import sxc.util.*;

import java.util.ArrayList;
import java.util.Scanner;

public class DegreeDAOImplementation implements DegreeInterface {

	public static DegreeDAOImplementation getInstance()
	{
		DegreeDAOImplementation obj=new DegreeDAOImplementation();
		return obj;
	}
	
	public void addDegree(String name, int durationInYears) throws Exception {

		Connection con = TestConnect.getConnection();

		Statement stmt = con.createStatement();

		Logger logger= Logger.getInstance();
		
		String sql = "insert into degree(deg_id,deg_name,no_of_yr) values(degree_seq.nextval,'" + name + "',"
				+ durationInYears + ")";

		logger.info(sql);

		logger.info("Degree Inserted");

		stmt.close();
		con.close();

	}

	public String getDegreeName(int degId) throws Exception {

		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();
		
		Logger logger=Logger.getInstance();
		
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
			throw new NotFoundException("Degree doesnot Exist");
		}

		stmt.close();
		con.close();

		return degName;

	}

	public int getDegreeId(String degName) throws Exception {
		Connection con = TestConnect.getConnection();

		Statement stmt = con.createStatement();
		Logger logger=Logger.getInstance();
		
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

	public ArrayList<Degree> getAllDegree() throws Exception {
		// TODO Auto-generated method stub
		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();
		Logger logger=Logger.getInstance();
		
		ArrayList<Degree> list = new ArrayList<Degree>();

		String sql = "select * from degree";
		logger.info(sql);

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("deg_id");
			String name = rs.getString("deg_name");

			Degree d = new Degree();
			d.setId(id);
			d.setName(name);

			list.add(d);

		}
		stmt.close();
		con.close();

		return list;
	}

}
