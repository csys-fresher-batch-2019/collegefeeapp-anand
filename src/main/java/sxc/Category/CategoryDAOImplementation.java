package sxc.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryDAOImplementation implements CategoryInterface {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.201:1521:XE", "system", "oracle");
		return con;
	}

	public void addFeeCategory(String name) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		Statement stmt = con.createStatement();

		String sql = "insert into fee_category(fee_category_id,fee_category_name) values(fee_category_seq.nextval,'"
				+ name + "')";
		stmt.executeUpdate(sql);

		System.out.println(sql);
		System.out.println("Category added");

	}

	public int getFeeCategoryId(String name) throws Exception {
		// TODO Auto-generated method stub

		Connection con = getConnection();

		Statement stmt = con.createStatement();

		String sql = "select fee_category_id from fee_category where fee_category_name='" + name + "'";
		System.out.println(sql);

		ResultSet rs = stmt.executeQuery(sql);
		int id = 0;
		if (rs.next()) {
			id = rs.getInt("fee_category_id");
		}

		return id;
	}

	public String getFeeCategoryName(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConnection();

		Statement stmt = con.createStatement();

		String sql = "select fee_category_name from fee_category where fee_category_id=" + id + "";
		System.out.println(sql);

		ResultSet rs = stmt.executeQuery(sql);
		String name = null;
		if (rs.next()) {
			name = rs.getString("fee_category_name");
		}

		return name;
	}

}
