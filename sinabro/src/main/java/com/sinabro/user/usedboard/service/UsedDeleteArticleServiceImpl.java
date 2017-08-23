package com.sinabro.user.usedboard.service;

import com.sinabro.user.usedboard.dao.UsedBoardDao;

public class UsedDeleteArticleServiceImpl implements UsedDeleteArticleService{

	private UsedBoardDao usedBoardDao;
	
	public void setUsedBoardDao(UsedBoardDao usedBoardDao) {
		this.usedBoardDao = usedBoardDao;
	}

	

	@Override
	public void deleteArticle(Integer num) {
		this.usedBoardDao.deleteArticle(num);
	}
}
