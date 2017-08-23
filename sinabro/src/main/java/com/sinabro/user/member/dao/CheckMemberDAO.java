package com.sinabro.user.member.dao;

import java.util.List;

public interface CheckMemberDAO {

	public String checkId(String id);
	public List<String> findId(String name);
	public List<String> getId(Object obj);
	public String findPw(String id);
	int changePw(Object obj);
}
