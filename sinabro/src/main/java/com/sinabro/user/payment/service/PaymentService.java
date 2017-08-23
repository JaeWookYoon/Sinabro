package com.sinabro.user.payment.service;

import com.sinabro.model.MemberVO;
import com.sinabro.model.ProductVO;

public interface PaymentService {
	MemberVO getMember(String id);
	ProductVO getProductOrder(String product_code);
}
