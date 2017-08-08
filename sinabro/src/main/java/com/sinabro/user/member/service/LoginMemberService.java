package com.sinabro.user.member.service;

import com.sinabro.model.MemberVO;

public interface LoginMemberService {

	public MemberVO getUserInfo(String id);
	int updateIp(Object map);
	int deleteIp(Object map);
	String checkIp(String id);
}
