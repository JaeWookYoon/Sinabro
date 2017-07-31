package com.sinabro.user.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.MemberVO;



public class AddMemberDAOImpl implements AddMemberDAO{

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace="com.sinabro.member.usermember.";
	
	@Override
	public int addMember(MemberVO vo) {
		// TODO Auto-generated method stub
		
		return sqlSessionTemplate.insert(namespace+"addUser",vo);
	}
	
	

}
