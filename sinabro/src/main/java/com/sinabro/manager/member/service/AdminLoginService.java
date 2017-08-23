package com.sinabro.manager.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.sinabro.model.MemberVO;

@Service
public interface AdminLoginService {

	//public AdminVO adminLoginCheck(AdminVO vo);

	public MemberVO getAdminInfo(String id);
	
	public void logout(HttpSession session);
	int updateIp(Object obj);
	int deleteIp(Object obj);
	String checkIp(String id);
}
