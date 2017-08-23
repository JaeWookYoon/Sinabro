package com.sinabro.user.usedboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinabro.model.UsedBoardVO;
import com.sinabro.user.board.dao.BoardDao;
import com.sinabro.user.usedboard.dao.UsedBoardDao;

@Service
public class UsedBoardListServiceImpl implements UsedBoardListService {

	private UsedBoardDao usedBoardDao;
	
	public void setUsedBoardDao(UsedBoardDao usedBoardDao) {
		this.usedBoardDao = usedBoardDao;
	}
	
	@Override
	public Integer getListCount(Object obj) {
		return this.usedBoardDao.getListCount(obj);
	}

	@Override
	public List<UsedBoardVO> getUsedBoardList(Object obj) {
		return this.usedBoardDao.getList(obj);
	}

}
