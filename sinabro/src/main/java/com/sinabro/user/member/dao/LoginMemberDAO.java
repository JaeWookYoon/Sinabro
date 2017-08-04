package com.sinabro.user.member.dao;

import com.sinabro.model.MemberVO;

public interface LoginMemberDAO {

	public MemberVO getUserInfo(String id);
	public int updateStatus(String id);
	int getStatus(String id);
	int outStatus(String id);
}
