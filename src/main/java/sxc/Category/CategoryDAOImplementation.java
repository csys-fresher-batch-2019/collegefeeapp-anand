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

	public void addFeeCategory(Category c) throws Exception {

		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		String sql = "insert into fee_category(fee_category_id,fee_category_name) values(fee_category_seq.nextval,'"
				+ c.getName() + "')";
		stmt.executeUpdate(sql);

		logger.info(sql);
		logger.info("Category added");
	}

	public int getFeeCategoryId(Category c) throws Exception {
		int id = 0;
		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		String sql = "select fee_category_id from fee_category where fee_category_name='" + c.getName() + "'";
		logger.info(sql);

		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			id = rs.getInt("fee_category_id");
		}

		return id;
	}

	public String getFeeCategoryName(Category c) throws Exception {
		String name = null;

		Connection con = TestConnect.getConnection();
		Statement stmt = con.createStatement();

		String sql = "select fee_category_name from fee_category where fee_category_id=" + c.getId() + "";
		logger.info(sql);

		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			name = rs.getString("fee_category_name");
		} else {
			throw new NotFoundException("Category doesnot exist");
		}
		return name;
	}

}
