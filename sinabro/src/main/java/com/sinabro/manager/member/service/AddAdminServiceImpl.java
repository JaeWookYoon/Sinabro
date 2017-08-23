package com.sinabro.manager.member.service;

import com.sinabro.manager.member.dao.AddAdminDAO;
import com.sinabro.model.MemberVO;
import com.sinabro.util.BCrypt;
import com.sinabro.util.SHA256;

public class AddAdminServiceImpl implements AddAdminService{

	private AddAdminDAO addAdminDAO;
	
	private BCrypt crypt;
	private SHA256 sha;
	
	public void setAddAdminDAO(AddAdminDAO addAdminDAO) {
		this.addAdminDAO = addAdminDAO;
	}
	
	public void setCrypt(BCrypt crypt) {
		this.crypt = crypt;
	}


	public void setSha(SHA256 sha) {
		this.sha = sha;
	}



	@Override
	public int addAdmin(MemberVO vo) {
		// TODO Auto-generated method stub
		String password=vo.getPassword();
		String sh=sha.getString(password.getBytes());
		String hash=crypt.hashpw(sh, BCrypt.gensalt(12));
		vo.setPassword(hash);
		int result=addAdminDAO.addAdmin(vo);
		return result;
	}

	@Override
	public boolean adminCheckId(String id) {
		// TODO Auto-generated method stub
		String result=addAdminDAO.adminCheckId(id);
		if(result!=null) {
		return false;
		}else {
			return true;
		}
	}

}
