package sxc.Department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sxc.util.Logger;

public class DeptDAOImplementation implements DeptInterface {

	public void addDepartment(String name) throws Exception {
		Connection con = getConnection();
		Logger logger=new Logger();
		
		Statement stmt = con.createStatement();
		String sql = "insert into department(dept_id,dept_name) values( department_seq.nextval ,'" + name + "')";
		logger.info(sql);
		int rows = stmt.executeUpdate(sql);
		logger.info("NO OF ROWS AFFECTED:" + rows);

		stmt.close();
		con.close();
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.201:1521:XE", "system", "oracle");
		return con;
	}

	public int getDepartmentId(String departmentName) throws Exception {
		Connection con = getConnection();

		Statement stmt = con.createStatement();

		Logger logger=new Logger();
		
		int deptId = 0;
		String sql1 = "select dept_id from department where dept_name='" + departmentName + "'";
		logger.info(sql1);
		ResultSet rs1 = stmt.executeQuery(sql1);
		if (rs1.next()) {
			deptId = rs1.getInt("dept_id");
		} else {
			throw new Exception("Department does not Exist");
		}
		stmt.close();
		con.close();

		return deptId;
	}

	public String getDepartmentName(int dept_id) throws Exception {
		Connection con = getConnection();

		Statement stmt = con.createStatement();

		Logger logger=new Logger();
		String deptName = "";
		String sql = "select dept_name from department where dept_id=" + dept_id + "";
		logger.info(sql);

		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			deptName = rs.getString("dept_name");
		} else {
			throw new Exception("Department does not exist");
		}
		stmt.close();
		con.close();

		return deptName;
	}

	public ArrayList<Department> listAllDepartments() throws Exception {
		Connection con = getConnection();
		Logger logger=new Logger();
		
		Statement stmt = con.createStatement();

		ArrayList<Department> list = new ArrayList<Department>();

		String sql = "select * from department";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("dept_id");
			String name = rs.getString("dept_name");

			Department d = new Department();
			d.deptId = id;
			d.deptName = name;

			list.add(d);
		}
		stmt.close();
		con.close();

		return list;
	}

}
