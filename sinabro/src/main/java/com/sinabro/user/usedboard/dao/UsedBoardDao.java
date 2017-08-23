package com.sinabro.user.usedboard.dao;

import java.util.List;

import com.sinabro.model.BoardVO;
import com.sinabro.model.UsedBoardVO;

public interface UsedBoardDao {

	int getListCount(Object obj); // 전체 글 수 or 검색한 글 수

	List<UsedBoardVO> getList(Object obj); // 전체 글 or 검색한 글 리스트

	void insertArticle(UsedBoardVO usedBoardVo); // 글 입력

	UsedBoardVO getArticle(Integer num); // 글 가져오기

	void updateArticle(UsedBoardVO usedBoardVO); // 글 입력

	 

	void deleteArticle(Integer num); // 글 삭제
}
