package com.sinabro.user.member.dao;

import com.sinabro.model.MemberVO;

public interface ChangeDAO {
	int updateMember(Object obj);
	int deleteMember(String id);
	MemberVO getUser(String id);
}
