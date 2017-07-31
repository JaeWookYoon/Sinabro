package com.sinabro.user.board.service;

import com.sinabro.user.board.dao.BoardDao;
import com.sinabro.model.BoardVO;

public class WriteServiceImpl implements WriteService{

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public void insertWriting(BoardVO boardVo) {
		this.boardDao.insertArticle(boardVo);
	}
}
