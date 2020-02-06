package sxc.Payment;

import java.util.List;

public interface PaymentInterface {

	void addPayment(PaymentDetail p) throws Exception;
	List <PaymentDetail> listbysem(int semId) throws Exception;
	List <PaymentDetail> listbyregno(String regno)throws Exception;
		
}
