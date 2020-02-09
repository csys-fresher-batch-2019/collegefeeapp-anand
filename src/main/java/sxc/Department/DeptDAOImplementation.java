package sxc.department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import sxc.sxcException.NotFoundException;
import sxc.util.Logger;
import sxc.util.TestConnect;

public class DeptDAOImplementation implements DeptInterface {

	public static DeptDAOImplementation getInstance() {
		return new DeptDAOImplementation();
	}

	public void addDepartment(String name) throws Exception {
		Connection con = TestConnect.getConnection();
		Logger logger = Logger.getInstance();

		Statement stmt = con.createStatement();
		String sql = "insert into department(dept_id,dept_name) values( department_seq.nextval ,'" + name.toUpperCase()
				+ "')";
		logger.info(sql);
		int rows = stmt.executeUpdate(sql);
		logger.info("NO OF ROWS AFFECTED:" + rows);

		stmt.close();
		con.close();
	}

	public int getDepartmentId(String departmentName) throws Exception {
		Connection con = TestConnect.getConnection();

		Statement stmt = con.createStatement();

		Logger logger = Logger.getInstance();

		int deptId = 0;
		String sql1 = "select dept_id from department where dept_name='" + departmentName + "'";
		logger.info(sql1);
		ResultSet rs1 = stmt.executeQuery(sql1);
		if (rs1.next()) {
			deptId = rs1.getInt("dept_id");
		} else {
			throw new NotFoundException("Department does not Exist");
		}
		stmt.close();
		con.close();

		return deptId;
	}

	public String getDepartmentName(int deptId) throws Exception {
		Connection con = TestConnect.getConnection();

		Statement stmt = con.createStatement();

		Logger logger = Logger.getInstance();
		String deptName = "";
		String sql = "select dept_name from department where dept_id=" + deptId + "";
		logger.info(sql);

		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			deptName = rs.getString("dept_name");
		} else {
			throw new NotFoundException("Department does not exist");
		}
		stmt.close();
		con.close();

		return deptName;
	}

	public ArrayList<String> listAllDepartments() throws Exception {
		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		ArrayList<String> list = new ArrayList<>();

		String sql = "select * from department";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String name = rs.getString("dept_name");

			Department d =  Department.getInstance();
			d.setDeptName(name);

			list.add(d.getDeptName());
		}
		stmt.close();
		con.close();

		return list;
	}

}
