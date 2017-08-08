package com.sinabro.user.member.dao;

import com.sinabro.model.MemberVO;

public interface LoginMemberDAO {

	public MemberVO getUserInfo(String id);
	int updateIp(Object map);
	int deleteIp(Object map);
	String checkIp(String id);
}
