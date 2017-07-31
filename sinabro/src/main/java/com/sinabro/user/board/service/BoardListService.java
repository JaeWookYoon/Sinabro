package com.sinabro.user.board.service;

import java.util.List;

import com.sinabro.model.BoardVO;

public interface BoardListService {
	
	Integer getListCount(Object obj);
	List<BoardVO> getBoardList(Object obj);

}
