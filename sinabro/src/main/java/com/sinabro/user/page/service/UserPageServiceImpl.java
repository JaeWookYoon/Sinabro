package com.sinabro.user.page.service;

import java.util.List;

import com.sinabro.model.BoardVO;
import com.sinabro.model.MemberVO;
import com.sinabro.user.page.dao.UserPageDAO;

public class UserPageServiceImpl implements UserPageService{

	private UserPageDAO userPagedao;
	@Override
	public List<BoardVO> getMyboard(Object obj) {
		// TODO Auto-generated method stub
		return userPagedao.getMyboard(obj);
	}

	@Override
	public int getMycount(String id) {
		// TODO Auto-generated method stub
		return userPagedao.getMycount(id);
	}

	public void setUserPagedao(UserPageDAO userPagedao) {
		this.userPagedao = userPagedao;
	}

	

}
