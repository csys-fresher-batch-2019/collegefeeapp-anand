package sxc.Payment;

import java.util.ArrayList;
import java.util.List;

public class TestPaymentBySemId {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		
		PaymentDAOImplementation obj=new PaymentDAOImplementation();
		List<PaymentDetail> list=new ArrayList<PaymentDetail>();
		list=obj.listbysem(1);
	}

}
