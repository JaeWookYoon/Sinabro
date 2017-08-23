package com.sinabro.manager.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinabro.model.MemberVO;

@Repository
public class ManagementDAOImpl implements ManagementDAO {
	private String namespace = "com.sinabro.member.adminMember.";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<MemberVO> getUserList(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String, Object>) obj;
		if (map.get("search_type").equals("all")) {
			return sqlSessionTemplate.selectList(namespace + "getUserAllList", obj);
		} else if (map.get("search_type").equals("id")) {
			return sqlSessionTemplate.selectList(namespace + "getUserIdList", obj);
		} else if (map.get("search_type").equals("name")) {
			return sqlSessionTemplate.selectList(namespace + "getUserNameList", obj);
		} else {
			return sqlSessionTemplate.selectList(namespace + "userList", obj);
		}
	}

	@Override
	public int getUserCount(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String, Object>) obj;
		if (map.get("search_type").equals("all")) {
			return sqlSessionTemplate.selectOne(namespace + "getUserAllCount", obj);
		} else if (map.get("search_type").equals("id")) {
			return sqlSessionTemplate.selectOne(namespace + "getUserIdCount", obj);
		} else if (map.get("search_type").equals("name")) {
			return sqlSessionTemplate.selectOne(namespace + "getUserNameCount", obj);
		} else {
			return sqlSessionTemplate.selectOne(namespace + "getUserCount", obj);
		}
	}

	@Override
	public List<MemberVO> getAdminList(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String, Object>) obj;
		if (map.get("search_type").equals("all")) {
			return sqlSessionTemplate.selectList(namespace + "getAdminAllList", obj);
		} else if (map.get("search_type").equals("id")) {
			return sqlSessionTemplate.selectList(namespace + "getAdminIdList", obj);
		} else if (map.get("search_type").equals("name")) {
			return sqlSessionTemplate.selectList(namespace + "getAdminNameList", obj);
		} else {
			return sqlSessionTemplate.selectList(namespace + "adminList", obj);
		}
	}

	@Override
	public int getAdminCount(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String, Object>) obj;
		if (map.get("search_type").equals("all")) {
			return sqlSessionTemplate.selectOne(namespace + "getAdminAllCount", obj);
		} else if (map.get("search_type").equals("id")) {
			return sqlSessionTemplate.selectOne(namespace + "getAdminIdCount", obj);
		} else if (map.get("search_type").equals("name")) {
			return sqlSessionTemplate.selectOne(namespace + "getAdminNameCount", obj);
		} else {
			return sqlSessionTemplate.selectOne(namespace + "getAdminCount", obj);
		}
	}

	@Override
	public MemberVO getUserInformation(String id) {
		return sqlSessionTemplate.selectOne(namespace + "getUserInformation", id);
	}

	@Override
	public int deleteUserInformation(String id) {
		return sqlSessionTemplate.delete(namespace + "deleteUserInformation", id);
	}

	@Override
	public void updateUserInformation(MemberVO memberVo) {
		sqlSessionTemplate.update(namespace + "updateUserInformation", memberVo);
	}
	
	@Override
	public MemberVO getAdminInformation(String id) {
		return sqlSessionTemplate.selectOne(namespace + "getAdminInformation", id);
	}

	@Override
	public int deleteAdminInformation(String id) {
		return sqlSessionTemplate.delete(namespace + "deleteAdminInformation", id);
	}

	@Override
	public void updateAdminInformation(MemberVO memberVo) {
		sqlSessionTemplate.update(namespace + "updateAdminInformation", memberVo);
	}
}
