package sxc.payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sxc.util.Logger;

public class TestGetPaymentByRegno {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		Logger logger = Logger.getInstance();

		String regno = sc.nextLine().toUpperCase();

		PaymentDAOImplementation obj = PaymentDAOImplementation.getInstance();
		List<PaymentDetail> list = new ArrayList<PaymentDetail>();
		list = obj.listbyregno(regno);
		logger.info(list.toString());
	}

}
