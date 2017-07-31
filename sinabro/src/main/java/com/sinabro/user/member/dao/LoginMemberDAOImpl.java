package com.sinabro.user.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.MemberVO;

public class LoginMemberDAOImpl implements LoginMemberDAO{

	private SqlSessionTemplate sqlSessionTemplate;

	private String namespace="com.sinabro.member.usermember.";
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public MemberVO getUserInfo(String id) {
		// TODO Auto-generated method stub
		
		return sqlSessionTemplate.selectOne(namespace+"getUserInfo",id);
	}
}
