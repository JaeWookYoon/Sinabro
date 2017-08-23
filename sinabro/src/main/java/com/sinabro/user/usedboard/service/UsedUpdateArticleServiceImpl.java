package com.sinabro.user.usedboard.service;

import com.sinabro.model.UsedBoardVO;
import com.sinabro.user.usedboard.dao.UsedBoardDao;

public class UsedUpdateArticleServiceImpl implements UsedUpdateArticleService {

	private UsedBoardDao usedBoardDao;

	public void setUsedBoardDao(UsedBoardDao usedBoardDao) {
		this.usedBoardDao = usedBoardDao;
	}

	@Override
	public UsedBoardVO getArticle(Integer num) {
		return this.usedBoardDao.getArticle(num);
	}

	

	@Override
	public void updateArticle(UsedBoardVO usedBoardVo) {
		this.usedBoardDao.updateArticle(usedBoardVo);
	}
}
