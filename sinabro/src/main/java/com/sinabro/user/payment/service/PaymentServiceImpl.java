package com.sinabro.user.payment.service;

import com.sinabro.model.MemberVO;
import com.sinabro.model.ProductVO;
import com.sinabro.user.payment.dao.PaymentDAO;

public class PaymentServiceImpl implements PaymentService{

	private PaymentDAO paymentDAO;
	
	
	
	
	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}




	@Override
	public ProductVO getProductOrder(String product_code) {
		// TODO Auto-generated method stub
		return paymentDAO.getProductOrder(product_code);
	}




	@Override
	public MemberVO getMember(String id) {
		// TODO Auto-generated method stub
		return paymentDAO.getMember(id);
	}

}
