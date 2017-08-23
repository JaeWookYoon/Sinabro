package com.sinabro.user.cart.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.CartVO;
import com.sinabro.model.ProductVO;

public class CartListDAOImpl implements CartListDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	private String nameSpace="bascket.";
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public ProductVO getCartList(String product_code) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(nameSpace+"getCartList", product_code);
	}

	@Override
	public int insertCart(CartVO cart) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(nameSpace+"insertCart",cart);
	}

	@Override
	public List<CartVO> getCart(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(nameSpace+"getCart", id);
	}

	@Override
	public int deleteCart(Object obj) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete(nameSpace+"deleteCart",obj);
	}
	
	

}
