package com.sinabro.manager.member.dao;

import java.util.List;

import com.sinabro.model.MemberVO;

public interface ManagementDAO {

	//user
	public List<MemberVO> getUserList(Object obj);
	public int getUserCount(Object obj);
	public MemberVO getUserInformation(String id);
	public int deleteUserInformation(String id);
	public void updateUserInformation(MemberVO memberVo);
	//admin
	public List<MemberVO> getAdminList(Object obj);
	public int getAdminCount(Object obj);
	public MemberVO getAdminInformation(String id);
	public int deleteAdminInformation(String id);
	public void updateAdminInformation(MemberVO memberVo);
}
