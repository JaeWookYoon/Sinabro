package com.sinabro.user.usedboard.service;

import com.sinabro.model.UsedBoardVO;
import com.sinabro.user.usedboard.dao.UsedBoardDao;

public class UsedWriteServiceImpl implements UsedWriteService {

	private UsedBoardDao usedBoardDao;

	public void setUsedBoardDao(UsedBoardDao usedBoardDao) {
		this.usedBoardDao = usedBoardDao;
	}

	@Override
	public void insertWriting(UsedBoardVO usedBoardVo) {
		this.usedBoardDao.insertArticle(usedBoardVo);
	}
}
