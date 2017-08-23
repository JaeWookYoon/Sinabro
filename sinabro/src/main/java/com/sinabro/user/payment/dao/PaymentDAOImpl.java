package com.sinabro.user.payment.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.MemberVO;
import com.sinabro.model.ProductVO;

public class PaymentDAOImpl implements PaymentDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace="com.sinabro.user.payment.dao.user-payment.";
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


	@Override
	public ProductVO getProductOrder(String product_code) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getProductOrder", product_code);
	}


	@Override
	public MemberVO getMember(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getMember", id);
	}

}
