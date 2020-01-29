package sxc.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestGetPaymentByRegno {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String regno=sc.nextLine().toUpperCase();
		
		PaymentDAOImplementation obj=new PaymentDAOImplementation();
		List<PaymentDetail> list=new ArrayList<PaymentDetail>();
		list=obj.listbyregno(regno);
		System.out.println(list.toString());
	}

}
