package com.sinabro.user.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinabro.model.MemberVO;

public class ChangeDAOImpl implements ChangeDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace="com.sinabro.member.usermember.";
	
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int updateMember(Object obj) {
		
		return sqlSessionTemplate.update(namespace+"updateMember", obj);
	}

	@Override
	public int deleteMember(String id) {
		
		return 0;
	}

	@Override
	public MemberVO getUser(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getUserInfo", id);
	}

}
