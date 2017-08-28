package com.sinabro.user.payment.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.PaymentVO;

public class PaymentOrderDAOImpl implements PaymentOrderDAO {

	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace="com.sinabro.user.payment.dao.user-payment.";
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int insertPayment(PaymentVO vo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(namespace+"insertPayment", vo);
	}

	@Override
	public int updateMilage(String id,double milage) {
		// TODO Auto-generated method stub
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("id", id); map.put("milage", milage);
		return sqlSessionTemplate.update(namespace+"updateMilage", map);
	}

	@Override
	public int reduceQuantity(String product_code,String quan) {
		
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("product_code", product_code);map.put("quantity", quan);
		return sqlSessionTemplate.update(namespace+"reduceQuan", map);
	}

	@Override
	public int deleteCart(String id,String product_code) {
		// TODO Auto-generated method stub
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("id", id); map.put("product_code", product_code);
		return sqlSessionTemplate.delete(namespace+"deleteCartOne", map);
	}

	@Override
	public String getSize(String product_code) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getSize", product_code);
	}

	@Override
	public String getQuan(String product_code) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getQuan", product_code);
	}

	@Override
	public int getUserMilage(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getUserMilage", id);
	}

	@Override
	public int reduceMilage(String id, int milage) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", id); map.put("milage", milage);
		return sqlSessionTemplate.update(namespace+"reduceMilage",map);
	}

}
