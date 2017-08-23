package com.sinabro.manager.product.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.BrandVO;
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
	public int img_SEQ() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"imgSEQ");
	}


	@Override
	public List<BrandVO> getBrand() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"getBrand");
	}


	@Override
	public int insertBrand(BrandVO vo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(namespace+"insertBrand", vo);
	}


	@Override
	public int updateBrand(BrandVO vo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(namespace+"updateBrand",vo);
	}


	@Override
	public int deleteBrand(String brand) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete(namespace+"deleteBrand", brand);
	}

}
