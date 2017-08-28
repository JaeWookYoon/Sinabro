package com.sinabro.user.payment.dao;

import com.sinabro.model.PaymentVO;

public interface PaymentOrderDAO {
	String getSize(String product_code);
	String getQuan(String product_code);
int insertPayment(PaymentVO vo);
int updateMilage(String id,double milage);
int reduceQuantity(String product_code,String quan);
int deleteCart(String id,String product_code);
int getUserMilage(String id);
int reduceMilage(String id,int milage);
}
