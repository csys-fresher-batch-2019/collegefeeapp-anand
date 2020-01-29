package sxc.Payment;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface PaymentInterface {

	void addPayment(String studentId,int categoryId,int semId,int amount) throws Exception;
	List <PaymentDetail> listbysem(int semId) throws Exception;
	List <PaymentDetail> listbyregno(String regno)throws Exception;
	List <PaymentDetail> listbyCategoryId(int categoryId,int semId) throws Exception;
	List <PaymentDetail> listbyDeptName(String departmentName,int semId)throws Exception;
	List <PaymentDetail> listbyCourseId(int courseId,int semId)throws Exception;
		
}
