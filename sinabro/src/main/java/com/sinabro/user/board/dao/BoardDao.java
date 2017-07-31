package com.sinabro.user.board.dao;

import java.util.List;

import com.sinabro.model.BoardVO;

public interface BoardDao {

	int getListCount(Object obj); // 전체 글 수 or 검색한 글 수

	List<BoardVO> getList(Object obj); // 전체 글 or 검색한 글 리스트

	void insertArticle(BoardVO boardVo); // 글 입력

	BoardVO getArticle(Integer num); // 글 가져오기

	void updateArticle(BoardVO boardVo); // 글 입력

	

	void deleteArticle(Integer num); // 글 삭제
}
