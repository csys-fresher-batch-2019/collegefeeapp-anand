package sxc.payment;

import java.util.ArrayList;
import java.util.List;

import sxc.util.Logger;

public class TestPaymentBySemId {

	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getInstance();
		PaymentDAOImplementation obj = PaymentDAOImplementation.getInstance();
		List<PaymentDetail> list = new ArrayList<PaymentDetail>();
		list = obj.listbysem(1);
		logger.info(list.toString());
	}

}
