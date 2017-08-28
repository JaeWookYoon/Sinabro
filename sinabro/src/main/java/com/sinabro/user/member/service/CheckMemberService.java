package com.sinabro.user.member.service;

import java.util.List;

public interface CheckMemberService {

	boolean checkId(String id);
	String findId(String name,String email);
	List<String> getId(Object obj);
	String findPw(String id,String email);
	String changPw(String id);
	int getPoint(String id);
}
