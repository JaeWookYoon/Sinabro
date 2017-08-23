package com.sinabro.manager.member.service;

import java.util.List;

import com.sinabro.manager.member.dao.ManagementDAO;
import com.sinabro.model.MemberVO;

public class ManagementServiceImpl implements ManagementService {

	private ManagementDAO managementDAO;

	public void setManagementDAO(ManagementDAO managementDAO) {
		this.managementDAO = managementDAO;
	}

	@Override
	public List<MemberVO> userList(Object obj) {
		return this.managementDAO.getUserList(obj);
	}

	@Override
	public Integer getUserCount(Object obj) {
		return this.managementDAO.getUserCount(obj);
	}

	@Override
	public List<MemberVO> adminList(Object obj) {
		return this.managementDAO.getAdminList(obj);
	}

	@Override
	public Integer getAdminCount(Object obj) {
		return this.managementDAO.getAdminCount(obj);
	}

	@Override
	public MemberVO getUserInformation(String id) {
		return this.managementDAO.getUserInformation(id);
	}

	@Override
	public int deleteUserInformation(String id) {
		return this.managementDAO.deleteUserInformation(id);
	}

	@Override
	public void updateUserInformation(MemberVO memberVo) {
		this.managementDAO.updateUserInformation(memberVo);
	}

	@Override
	public MemberVO getAdminInformation(String id) {
		return this.managementDAO.getAdminInformation(id);
	}

	@Override
	public int deleteAdminInformation(String id) {
		return this.managementDAO.deleteAdminInformation(id);
	}

	@Override
	public void updateAdminInformation(MemberVO memberVo) {
		this.managementDAO.updateAdminInformation(memberVo);
	}
}
