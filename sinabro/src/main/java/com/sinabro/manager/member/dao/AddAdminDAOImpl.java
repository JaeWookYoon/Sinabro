package com.sinabro.manager.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.sinabro.model.MemberVO;

public class AddAdminDAOImpl implements AddAdminDAO {

	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	private String namespace = "com.sinabro.member.adminMember.";

	@Override
	public int addAdmin(MemberVO vo) {

		return sqlSessionTemplate.insert(namespace + "addAdmin", vo);
	}

	@Override
	public String adminCheckId(String id) {
		
		return sqlSessionTemplate.selectOne(namespace+"adminCheckId", id);
	}
}
