package com.sinabro.user.payment.service;

import java.util.ArrayList;
import java.util.List;

import com.sinabro.model.MyPaymentVO;
import com.sinabro.model.PaymentVO;
import com.sinabro.user.payment.dao.MyPaymentDAO;

public class MyPaymentServiceImpl implements MyPaymentService{

	private MyPaymentDAO myPaymentDAO;
	
	
	
	
	public void setMyPaymentDAO(MyPaymentDAO myPaymentDAO) {
		this.myPaymentDAO = myPaymentDAO;
	}




	@Override
	public List<MyPaymentVO> getComplpeInfo(String id) {
		List<PaymentVO>list=myPaymentDAO.getPaymentInfo(id);
		List<MyPaymentVO> payment=new ArrayList<MyPaymentVO>();
		for(int i=0;i<list.size();i++) {
			MyPaymentVO vo=new MyPaymentVO();
			
			vo.setNum(list.get(i).getNum());
			vo.setId(list.get(i).getId());
			vo.setProduct_code(list.get(i).getProduct_code());
			vo.setDatea(list.get(i).getDatea());
			vo.setPrice(list.get(i).getPrice());
			vo.setOrder_code(list.get(i).getOrder_code());
			vo.setStatus(list.get(i).getStatus());
			vo.setAddress(list.get(i).getAddress());
			vo.setOrder_message(list.get(i).getOrder_message());
			vo.setSizea(list.get(i).getSizea());
			vo.setNameone(list.get(i).getNameone());
			vo.setMainimg(myPaymentDAO.getProductImg(list.get(i).getProduct_code()));
		payment.add(vo);
		}
		return payment;
	}

	
}
