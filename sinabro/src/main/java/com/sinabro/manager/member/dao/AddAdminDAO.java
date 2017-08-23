package com.sinabro.manager.member.dao;

import com.sinabro.model.MemberVO;

public interface AddAdminDAO {

	public int addAdmin(MemberVO vo);
	public String adminCheckId(String id);
}
