package com.sinabro.user.payment.dao;

import com.sinabro.model.MemberVO;
import com.sinabro.model.ProductVO;

public interface PaymentDAO {
	MemberVO getMember(String id);
	ProductVO getProductOrder(String product_code);
}
