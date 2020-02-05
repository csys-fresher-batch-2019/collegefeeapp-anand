package sxc.Payment;

import java.util.ArrayList;
import java.util.List;

import sxc.util.Logger;

public class TestPaymentBySemId {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Logger logger = Logger.getInstance();
		PaymentDAOImplementation obj =  PaymentDAOImplementation.getInstance();
		List<PaymentDetail> list = new ArrayList<PaymentDetail>();
		try {
			list = obj.listbysem(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		logger.info(list.toString());
	}

}
