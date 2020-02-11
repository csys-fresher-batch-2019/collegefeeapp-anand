package sxc.payment;

import java.util.List;

import sxc.sxcException.DbException;
import sxc.sxcException.NotFoundException;

public interface PaymentInterface {

	void addPayment(PaymentDetail p) throws DbException;
	List <PaymentDetail> listbysem(int semId) throws DbException,NotFoundException;
	List <PaymentDetail> listbyregno(String regno)throws DbException,NotFoundException;
		
}
