package com.sinabro.user.product.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.ProductVO;

public class ProductListDAOImpl implements ProductListDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace="com.sinabro.user.product.userProduct.";
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<ProductVO> getProductList() {
	
		return sqlSessionTemplate.selectList(namespace+"getProductList");
	}

	@Override
	public List<ProductVO> getProductList(Object param) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"getProductSome", param);
	}

}
