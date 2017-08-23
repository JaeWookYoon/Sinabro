package com.sinabro.user.page.service;

import java.util.List;

import com.sinabro.model.BoardVO;
import com.sinabro.model.MemberVO;

public interface UserPageService {
	List<BoardVO> getMyboard(Object obj);
	int getMycount(String id);
	
}
