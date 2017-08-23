package com.sinabro.user.usedboard.service;

import java.util.List;

import com.sinabro.model.UsedBoardVO;

public interface UsedBoardListService {
	
	Integer getListCount(Object obj);
	List<UsedBoardVO> getUsedBoardList(Object obj);

}
