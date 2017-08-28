package com.sinabro.user.payment.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.PaymentVO;

public class MyPaymentDAOImpl implements MyPaymentDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace="com.sinabro.user.payment.dao.user-payment.";
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<PaymentVO> getPaymentInfo(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"getCompleInfo", id);
	}

	@Override
	public String getProductImg(String product_code) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getProductImg",product_code);
	}
	
	

}
