package sxc.Payment;

import java.util.ArrayList;
import java.util.List;
import sxc.util.Logger;
import sxc.util.TestConnect;
import java.sql.*;

public class PaymentDAOImplementation implements PaymentInterface {

	public static PaymentDAOImplementation getInstance() {

		return new PaymentDAOImplementation();
	}

	public void addPayment(PaymentDetail p) throws Exception {

		Connection con = TestConnect.getConnection();

		Statement stmt = con.createStatement();
		Logger logger = Logger.getInstance();

		String sql = "insert into payment(payment_id,payment_date,std_id,course_fee_id,sem_id,paid_amount) values(payment_seq.nextval,to_date(SYSDATE,'dd-MM-yyyy'),'"
				+ p.getRegno() + "'," + p.getFeeCourseId() + "," + p.getSemId() + "," + p.getAmount() + ")";

		logger.info(sql);
		stmt.executeUpdate(sql);

		logger.info("Payment Inserted");

	}

	public List<PaymentDetail> listbysem(int semId) throws Exception {
		Connection connection = TestConnect.getConnection();

		Statement st = connection.createStatement();
		Logger logger = Logger.getInstance();

		String sql = "select payment_id,payment_date,std_id,course_fee_id,paid_amount from payment where sem_id="
				+ semId + "";
		logger.info(sql);

		ResultSet rs = st.executeQuery(sql);

		ArrayList<PaymentDetail> list = new ArrayList<PaymentDetail>();

		while (rs.next()) {
			int id = rs.getInt("payment_id");
			Date date = rs.getDate("payment_date");
			String regno = rs.getString("std_id");
			int feeCourseId = rs.getInt("course_fee_id");
			int amount = rs.getInt("paid_amount");

			PaymentDetail pd = new PaymentDetail();
			pd.setId(id);
			pd.setAmount(amount);
			// LocalDate date2=date.valueOf(date);
			pd.setDate(date);
			pd.setFeeCourseId(feeCourseId);
			pd.setRegno(regno);
			pd.setSemId(semId);

			list.add(pd);

		}
		return list;
	}

	public List<PaymentDetail> listbyregno(String regno) throws Exception {
		Logger logger = Logger.getInstance();
		String sql = "select payment_id,payment_date,course_fee_id,sem_id,paid_amount from payment where std_id='"
				+ regno + "'";
		logger.info(sql);

		Connection con = TestConnect.getConnection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		ArrayList<PaymentDetail> list = new ArrayList<PaymentDetail>();

		PaymentDetail pd = new PaymentDetail();
		while (rs.next()) {
			int id = rs.getInt("payment_id");
			Date date = rs.getDate("payment_date");
			int feeCourseId = rs.getInt("course_fee_id");
			int amount = rs.getInt("paid_amount");
			int semId = rs.getInt("sem_id");

			pd.setId(id);
			pd.setSemId(semId);
			pd.setAmount(amount);
			pd.setDate(date);
			pd.setFeeCourseId(feeCourseId);
			pd.setRegno(regno);
			pd.setId(id);

			list.add(pd);

		}

		return list;
	}

	public List<PaymentDetail> listbyCategoryId(int categoryId, int semId) throws Exception {
		Logger logger = Logger.getInstance();
		String sql = "select course_fee_id,sum(paid_amount) from payment group by course_fee_id having sem_id =" + semId
				+ "";
		logger.info(sql);

		Connection con = TestConnect.getConnection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		List<PaymentDetail> list = new ArrayList<PaymentDetail>();

		PaymentDetail pd = new PaymentDetail();

		return list;
	}

	public List<PaymentDetail> listbyDeptName(String departmentName, int semId) throws Exception {
		Logger logger = Logger.getInstance();
		String sql = "select payment_id,payment_date,course_fee_id,sem_id,paid_amount from payment";
		logger.info(sql);

		Connection con = TestConnect.getConnection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		List<PaymentDetail> list = new ArrayList<PaymentDetail>();

		PaymentDetail pd = new PaymentDetail();

		return list;

	}

	public List<PaymentDetail> listbyCourseId(int courseId, int semId) throws Exception {
		Logger logger = Logger.getInstance();
		String sql = "select payment_id,payment_date,course_fee_id,sem_id,paid_amount from payment";
		logger.info(sql);

		Connection con = TestConnect.getConnection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		List<PaymentDetail> list = new ArrayList<PaymentDetail>();

		PaymentDetail pd = new PaymentDetail();

		return list;
	}

}
