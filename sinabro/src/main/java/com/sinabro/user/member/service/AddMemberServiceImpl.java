package com.sinabro.user.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinabro.model.MemberVO;
import com.sinabro.user.member.dao.AddMemberDAO;
import com.sinabro.util.BCrypt;
import com.sinabro.util.SHA256;

public class AddMemberServiceImpl implements AddMemberService{

	private AddMemberDAO addmemberDAO;
	
	private BCrypt crypt;
	private SHA256 sha;
	
	public void setCrypt(BCrypt crypt) {
		this.crypt = crypt;
	}


	public void setSha(SHA256 sha) {
		this.sha = sha;
	}


	public void setAddmemberDAO(AddMemberDAO addmemberDAO) {
		this.addmemberDAO = addmemberDAO;
	}


	@Override
	public int addUser(MemberVO vo) {
		// TODO Auto-generated method stub
		String password=vo.getPassword();
		String sh=sha.getString(password.getBytes());
		String hash=crypt.hashpw(sh, BCrypt.gensalt(12));
		vo.setPassword(hash);
		int result=addmemberDAO.addMember(vo);
		return result;
	}

}
