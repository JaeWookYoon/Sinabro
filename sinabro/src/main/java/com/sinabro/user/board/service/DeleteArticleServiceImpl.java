package com.sinabro.user.board.service;

import com.sinabro.user.board.dao.BoardDao;

public class DeleteArticleServiceImpl implements DeleteArticleService{

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	

	@Override
	public void deleteArticle(Integer num) {
		this.boardDao.deleteArticle(num);
	}
}
