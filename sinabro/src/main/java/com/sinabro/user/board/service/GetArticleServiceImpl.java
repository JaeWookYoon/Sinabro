package com.sinabro.user.board.service;

import com.sinabro.user.board.dao.BoardDao;
import com.sinabro.model.BoardVO;

public class GetArticleServiceImpl implements GetArticleService {

	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public BoardVO getArticle(Integer num) {
		return this.boardDao.getArticle(num);
	}
}
