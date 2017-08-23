package com.sinabro.user.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinabro.model.MemberVO;
import com.sinabro.user.member.dao.ChangeDAO;
import com.sinabro.util.BCrypt;
import com.sinabro.util.SHA256;

public class ChangeServiceImpl implements ChangeService{

	private ChangeDAO changeDAO;
	public void setChangeDAO(ChangeDAO changeDAO) {
		this.changeDAO = changeDAO;
	}

	@Override
	public int updateMember(MemberVO vo) {
		String password=vo.getPassword();
		SHA256 sha=SHA256.getInsatnce();
		String sh=sha.getString(password.getBytes());
		String brcypt=BCrypt.hashpw(sh, BCrypt.gensalt(12));
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("password", brcypt);
		map.put("zipcode", vo.getZipcode());
		map.put("address1", vo.getAddress1());
		map.put("address2", vo.getAddress2());
		map.put("phone",vo.getPhone());
		map.put("id",vo.getId());
		map.put("email", vo.getEmail());
		int result=changeDAO.updateMember(map);
		return result;
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO getUser(String id) {
		// TODO Auto-generated method stub
		return changeDAO.getUser(id);
	}
	
	

}
