package com.sinabro.user.board.dao;

import java.util.List;

import com.sinabro.model.BoardVO;

public interface BoardDao {

	int getListCount(Object obj); // ��ü �� �� or �˻��� �� ��

	List<BoardVO> getList(Object obj); // ��ü �� or �˻��� �� ����Ʈ

	void insertArticle(BoardVO boardVo); // �� �Է�

	BoardVO getArticle(Integer num); // �� ��������

	void updateArticle(BoardVO boardVo); // �� �Է�

	

	void deleteArticle(Integer num); // �� ����
}
