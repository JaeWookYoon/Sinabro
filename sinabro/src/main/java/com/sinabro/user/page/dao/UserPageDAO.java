package com.sinabro.user.page.dao;

import java.util.List;

import com.sinabro.model.BoardVO;
import com.sinabro.model.MemberVO;

public interface UserPageDAO {
	List<BoardVO> getMyboard(Object obj);
	int getMycount(String id);
	
}
