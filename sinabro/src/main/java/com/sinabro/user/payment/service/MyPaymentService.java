package com.sinabro.user.payment.service;

import java.util.List;

import com.sinabro.model.MyPaymentVO;
import com.sinabro.model.PaymentVO;

public interface MyPaymentService {
	List<MyPaymentVO> getComplpeInfo(String id);
	
}
