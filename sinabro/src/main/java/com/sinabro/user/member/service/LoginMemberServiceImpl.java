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
	public int updateStatus(String id) {
		// TODO Auto-generated method stub
		return loginDAO.updateStatus(id);
	}


	@Override
	public int getStatus(String id) {
		// TODO Auto-generated method stub
		return loginDAO.getStatus(id);
	}


	@Override
	public int outStatus(String id) {
		// TODO Auto-generated method stub
		return loginDAO.outStatus(id);
	}
		
		
	
	

}
