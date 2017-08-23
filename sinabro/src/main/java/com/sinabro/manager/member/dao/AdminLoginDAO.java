package com.sinabro.manager.member.dao;

import javax.servlet.http.HttpSession;

import com.sinabro.model.MemberVO;

public interface AdminLoginDAO {
	
	//public MemberVO AdminLoginCheck(MemberVO vo);

	public MemberVO getAdminInfo(String id);
	
	
	int updateIp(Object obj);
	int deleteIp(Object obj);
	String checkIp(String id);
}
