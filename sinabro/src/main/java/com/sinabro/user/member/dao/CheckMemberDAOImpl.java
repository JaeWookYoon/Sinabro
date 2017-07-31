package com.sinabro.user.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

public class CheckMemberDAOImpl implements CheckMemberDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace="com.sinabro.member.usermember.";
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public String checkId(String id) {
		
		
		
		return sqlSessionTemplate.selectOne(namespace+"checkId", id);
	}
	
	

}
