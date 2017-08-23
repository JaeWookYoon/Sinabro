package com.sinabro.manager.member.service;

import java.util.List;

import com.sinabro.model.MemberVO;

public interface ManagementService {
	//user
	public List<MemberVO> userList(Object obj);	
	public Integer getUserCount(Object obj);
	public MemberVO getUserInformation(String id);
	public int deleteUserInformation(String id);
	public void updateUserInformation(MemberVO memberVo);
	//admin
	public List<MemberVO> adminList(Object obj);
	public Integer getAdminCount(Object obj);
	public MemberVO getAdminInformation(String id);
	public int deleteAdminInformation(String id);
	public void updateAdminInformation(MemberVO memberVo);
}
