package com.sinabro.user.member.dao;

import java.util.List;

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

	@Override
	public List<String> findId(String name) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"findId", name);
	}
	public List<String> getId(Object obj) {
		return sqlSessionTemplate.selectList(namespace+"getId",obj);
	}

	@Override
	public String findPw(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"findPw", id);
	}

	@Override
	public int changePw(Object obj) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(namespace+"changePw", obj);
	}
	

}
