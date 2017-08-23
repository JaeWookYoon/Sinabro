package com.sinabro.manager.member.service;

import javax.servlet.http.HttpSession;

import com.sinabro.manager.member.dao.AdminLoginDAO;
import com.sinabro.model.MemberVO;

public class AdminLoginServiceImpl implements AdminLoginService {

	private AdminLoginDAO adminLoginDAO;

	public void setAdminLoginDao(AdminLoginDAO adminLoginDAO) {
		this.adminLoginDAO = adminLoginDAO;
	}

	// @Override
	// public AdminVO adminLoginCheck(AdminVO vo) {
	// AdminVO adminVo = adminLoginDAO.AdminLoginCheck(vo);
	// return adminVo;
	// }

	@Override
	public void logout(HttpSession session) {
		// 세션 정보 초기화
		session.invalidate();
		// session.removeAttribute("id");
	}

	@Override
	public MemberVO getAdminInfo(String id) {
		MemberVO memberVo = adminLoginDAO.getAdminInfo(id);
		return memberVo;
	}

	@Override
	public int updateIp(Object obj) {
		// TODO Auto-generated method stub
		return adminLoginDAO.updateIp(obj);
	}

	@Override
	public int deleteIp(Object obj) {
		// TODO Auto-generated method stub
		return adminLoginDAO.deleteIp(obj);
	}

	@Override
	public String checkIp(String id) {
		// TODO Auto-generated method stub
		return adminLoginDAO.checkIp(id);
	}
	

}
