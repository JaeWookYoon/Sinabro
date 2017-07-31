package com.sinabro.user.member.service;

import com.sinabro.user.member.dao.CheckMemberDAO;

public class CheckMemberServiceImpl implements CheckMemberService {

	private CheckMemberDAO checkDAO;

	public void setCheckDAO(CheckMemberDAO checkDAO) {
		this.checkDAO = checkDAO;
	}

	@Override
	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		String result=checkDAO.checkId(id);
		if(result!=null) {
		return false;
		}else {
			return true;
		}
	}

}
