package com.sinabro.user.certify.dao;

import org.mybatis.spring.SqlSessionTemplate;

public class CertifyDAOImpl implements CertifyDAO {

	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace="com.sinabro.user.certify.dao.user-certify.";
	
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


	@Override
	public int getPhone(Object obj) {
		// TODO Auto-generated method stub
		
		return sqlSessionTemplate.selectOne(namespace+"getPhone", obj);
	}

}
