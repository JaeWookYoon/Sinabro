package com.sinabro.user.payment.dao;

import java.util.List;

import com.sinabro.model.PaymentVO;

public interface MyPaymentDAO {
	List<PaymentVO> getPaymentInfo(String id);
	String getProductImg(String product_code);
}
