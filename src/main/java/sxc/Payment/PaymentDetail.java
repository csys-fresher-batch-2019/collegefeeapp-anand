package sxc.Payment;

import java.time.LocalDate;

public class PaymentDetail {

	public int id;
	public LocalDate date;
	public String regno;
	public int feeCategoryId;
	public int semId;
	public int amount;
	@Override
	public String toString() {
		return "PaymentDetail [id=" + id + ", date=" + date + ", regno=" + regno + ", feeCategoryId=" + feeCategoryId
				+ ", semId=" + semId + ", amount=" + amount + "]";
	}
	
}
