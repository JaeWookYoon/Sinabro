package com.sinabro.user.member.service;

import com.sinabro.model.MemberVO;

public interface ChangeService {
	int updateMember(MemberVO vo);
	int deleteMember(String id);
	MemberVO getUser(String id);
}
