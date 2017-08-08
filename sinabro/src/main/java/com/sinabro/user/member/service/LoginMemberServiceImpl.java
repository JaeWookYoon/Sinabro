package com.sinabro.user.member.service;

import com.sinabro.model.MemberVO;
import com.sinabro.user.member.dao.LoginMemberDAO;
import com.sinabro.util.BCrypt;
import com.sinabro.util.SHA256;

public class LoginMemberServiceImpl implements LoginMemberService{

	
	private LoginMemberDAO loginDAO;
	
	
	public void setLoginDAO(LoginMemberDAO loginDAO) {
		this.loginDAO = loginDAO;
	}


	@Override
	public MemberVO getUserInfo(String id) {
		
		return loginDAO.getUserInfo(id);
	}


	@Override
	public int updateIp(Object map) {
		// TODO Auto-generated method stub
		return loginDAO.updateIp(map);
	}


	@Override
	public int deleteIp(Object map) {
		// TODO Auto-generated method stub
		return loginDAO.deleteIp(map);
	}


	@Override
	public String checkIp(String id) {
		// TODO Auto-generated method stub
		return loginDAO.checkIp(id);
	}


	
		
	
	

}
