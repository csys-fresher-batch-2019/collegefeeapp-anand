package sxc.Payment;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import sxc.util.Logger;

import java.sql.*;

public class PaymentDAOImplementation implements PaymentInterface {

	public void addPayment(String studentId, int feeCourseId, int semId, int amount) throws Exception {

		Connection con = getConnection();

		Statement stmt = con.createStatement();
		Logger logger = new Logger();

		String sql = "insert into payment(payment_id,payment_date,std_id,course_fee_id,sem_id,paid_amount) values(payment_seq.nextval,to_date(SYSDATE,'dd-MM-yyyy'),'"
				+ studentId + "'," + feeCourseId + "," + semId + "," + amount + ")";

		logger.info(sql);
		stmt.executeUpdate(sql);

		logger.info("Payment Inserted");

	}

	public List<PaymentDetail> listbysem(int semId) throws Exception {
		// TODO Auto-generated method stub

		Connection connection = getConnection();

		Statement st = connection.createStatement();
		Logger logger = new Logger();

		String sql = "select payment_id,payment_date,std_id,course_fee_id,paid_amount from payment where sem_id="
				+ semId + "";
		logger.info(sql);

		ResultSet rs = st.executeQuery(sql);

		ArrayList<PaymentDetail> list = new ArrayList<PaymentDetail>();

		while (rs.next()) {
			int id = rs.getInt("payment_id");
			Date date = rs.getDate("payment_date");
			String regno = rs.getString("std_id");
			int feeCategoryId = rs.getInt("course_fee_id");
			int amount = rs.getInt("paid_amount");

			PaymentDetail pd = new PaymentDetail();
			pd.semId = semId;
			pd.amount = amount;
			pd.date = date.toLocalDate();
			pd.feeCategoryId = feeCategoryId;
			pd.regno = regno;
			pd.id = id;

			list.add(pd);

		}
		return list;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.201:1521:XE", "system",
				"oracle");

		System.out.println(connection);
		return connection;
	}

	public List<PaymentDetail> listbyregno(String regno) throws Exception {
		// TODO Auto-generated method stub
		Logger logger = new Logger();
		String sql = "select payment_id,payment_date,course_fee_id,sem_id,paid_amount from payment where std_id='"
				+ regno + "'";
		logger.info(sql);

		Connection con = getConnection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		ArrayList<PaymentDetail> list = new ArrayList<PaymentDetail>();

		PaymentDetail pd = new PaymentDetail();
		while (rs.next()) {
			int id = rs.getInt("payment_id");
			Date date = rs.getDate("payment_date");
			int feeCategoryId = rs.getInt("course_fee_id");
			int amount = rs.getInt("paid_amount");
			int semId = rs.getInt("sem_id");
			
			pd.id = id;
			pd.semId = semId;
			pd.amount = amount;
			pd.date = date.toLocalDate();
			pd.feeCategoryId = feeCategoryId;
			pd.regno = regno;
			pd.id = id;

			list.add(pd);

		}

		return list;
	}

	public List<PaymentDetail> listbyCategoryId(int categoryId, int semId) throws Exception {
		// TODO Auto-generated method stub
		Logger logger=new Logger();
		String sql = "select course_fee_id,sum(paid_amount) from payment group by course_fee_id having sem_id =" + semId
				+ "";
		logger.info(sql);

		Connection con = getConnection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		ArrayList<PaymentDetail> list = new ArrayList<PaymentDetail>();

		return list;
	}

	public List<PaymentDetail> listbyDeptName(String departmentName, int semId) throws Exception {
		// TODO Auto-generated method stub
		Logger logger=new Logger();
		String sql = "select payment_id,payment_date,course_fee_id,sem_id,paid_amount from payment";
		logger.info(sql);

		Connection con = getConnection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		ArrayList<PaymentDetail> list = new ArrayList<PaymentDetail>();

		PaymentDetail pd = new PaymentDetail();

		return list;

	}

	public List<PaymentDetail> listbyCourseId(int courseId, int semId) throws Exception {
		// TODO Auto-generated method stub
		Logger logger=new Logger();
		String sql = "select payment_id,payment_date,course_fee_id,sem_id,paid_amount from payment";
		logger.info(sql);

		Connection con = getConnection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		ArrayList<PaymentDetail> list = new ArrayList<PaymentDetail>();

		PaymentDetail pd = new PaymentDetail();

		return list;
	}

}
