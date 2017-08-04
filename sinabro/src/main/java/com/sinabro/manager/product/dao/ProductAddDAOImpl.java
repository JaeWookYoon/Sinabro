package com.sinabro.manager.product.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.ProductVO;

public class ProductAddDAOImpl implements ProductAddDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace="com.sinabro.manager.product.dao.";
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


	@Override
	public int addProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(namespace+"addProduct",vo);
	}

	
	@Override
	public int checkBrand(String brand) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"checkBrand",brand);
	}


	@Override
	public int newProductCode(String product_code) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(namespace+"newProductCode",product_code);
	}


	@Override
	public int insertBrand(String brand) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(namespace+"insertBrand",brand);
	}



	@Override
	public int img_SEQ() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"imgSEQ");
	}

}
