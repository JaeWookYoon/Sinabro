package com.sinabro.user.product.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.BrandVO;
import com.sinabro.model.ProductVO;

public class ProductListDAOImpl implements ProductListDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace="com.sinabro.user.product.userProduct.";
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<ProductVO> getProductList(Object map) {
	
		return sqlSessionTemplate.selectList(namespace+"getProductList",map);
	}

	@Override
	public List<ProductVO> getProductListB(Object param) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"getProductSome", param);
	}

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getListCount");
	}

	@Override
	public List<BrandVO> getBrand() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"getBrand");
	}

	@Override
	public ProductVO getProductContent(String product_code) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getProductContent", product_code);
	}

	@Override
	public BrandVO getBrand(String brand) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getBrandB", brand);
	}

	@Override
	public List<ProductVO> getProductListA(Object param) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"productBrand", param);
	}

	@Override
	public List<ProductVO> getProductListC(Object param) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"productCategory", param);
	}

	@Override
	public int getListCountBrand(Object obj) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getListCountBrand", obj);
	}

	@Override
	public int getListCountCategory(Object obj) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getListCountCategory", obj);
	}

	@Override
	public int getListCountBoth(Object obj) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getListCountBoth", obj);
	}

}
