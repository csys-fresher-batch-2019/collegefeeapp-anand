package sxc.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import sxc.SXCException.NotFoundException;
import sxc.util.Logger;
import sxc.util.TestConnect;

public class CategoryDAOImplementation implements CategoryInterface {

	Logger logger = Logger.getInstance();

	public static CategoryDAOImplementation getInstance() {
		return new CategoryDAOImplementation();
	}

	public void addFeeCategory(String name) throws Exception {

		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		String sql = "insert into fee_category(fee_category_id,fee_category_name) values(fee_category_seq.nextval,'"
				+ name + "')";
		stmt.executeUpdate(sql);

		logger.info(sql);
		logger.info("Category added");

	}

	public int getFeeCategoryId(String name) throws Exception {

		Connection con = TestConnect.getConnection();

		Statement stmt = con.createStatement();

		String sql = "select fee_category_id from fee_category where fee_category_name='" + name + "'";
		logger.info(sql);

		ResultSet rs = stmt.executeQuery(sql);
		int id = 0;
		if (rs.next()) {
			id = rs.getInt("fee_category_id");
		}

		return id;
	}

	public String getFeeCategoryName(int id) throws Exception {
		Connection con = TestConnect.getConnection();

		Statement stmt = con.createStatement();

		String sql = "select fee_category_name from fee_category where fee_category_id=" + id + "";
		logger.info(sql);

		ResultSet rs = stmt.executeQuery(sql);
		String name = null;
		if (rs.next()) {
			name = rs.getString("fee_category_name");
		} else {
			throw new NotFoundException("Category doesnot exist");
		}

		return name;
	}

}
