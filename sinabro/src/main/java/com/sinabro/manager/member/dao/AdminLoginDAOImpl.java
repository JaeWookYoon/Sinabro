package com.sinabro.manager.member.dao;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.sinabro.model.MemberVO;

@Repository
public class AdminLoginDAOImpl implements AdminLoginDAO {

	private String namespace = "com.sinabro.member.adminMember.";

	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public MemberVO getAdminInfo(String id) {
		return sqlSessionTemplate.selectOne(namespace + "getAdminInfo", id);
	}

	
	@Override
	public int updateIp(Object obj) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(namespace+"updateIp", obj);
	}

	@Override
	public int deleteIp(Object obj) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(namespace+"deleteIp", obj);
	}

	@Override
	public String checkIp(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"checkIp",id);
	}

}
