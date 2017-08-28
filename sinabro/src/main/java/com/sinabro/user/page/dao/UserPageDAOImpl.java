package com.sinabro.user.page.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.BoardVO;
import com.sinabro.model.MemberVO;

public class UserPageDAOImpl implements UserPageDAO{
	
	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace="com.sinabro.user.page.user-page.";
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<BoardVO> getMyboard(Object obj) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"getMyboard", obj);
	}

	@Override
	public int getMycount(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getMycount",id);
	}

	@Override
	public MemberVO getMemberInfo(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"getMemberInfo", id);
	}

	
	

}
