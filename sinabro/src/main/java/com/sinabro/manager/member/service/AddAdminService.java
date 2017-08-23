package com.sinabro.manager.member.service;

import com.sinabro.model.MemberVO;

public interface AddAdminService {

	public int addAdmin(MemberVO vo);
	boolean adminCheckId(String id);
}
