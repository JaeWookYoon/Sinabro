package com.sinabro.user.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinabro.user.board.dao.BoardDao;
import com.sinabro.model.BoardVO;

@Service
public class BoardListServiceImpl implements BoardListService {

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public Integer getListCount(Object obj) {
		return this.boardDao.getListCount(obj);
	}

	@Override
	public List<BoardVO> getBoardList(Object obj) {
		return this.boardDao.getList(obj);
	}

}
