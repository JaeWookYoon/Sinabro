package com.sinabro.user.member.service;

import com.sinabro.model.MemberVO;

public interface LoginMemberService {

	public MemberVO getUserInfo(String id);
	public int updateStatus(String id);
	int getStatus(String id);
	int outStatus(String id);
}
