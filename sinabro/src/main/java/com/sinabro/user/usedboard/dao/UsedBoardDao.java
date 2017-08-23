package com.sinabro.user.usedboard.dao;

import java.util.List;

import com.sinabro.model.BoardVO;
import com.sinabro.model.UsedBoardVO;

public interface UsedBoardDao {

	int getListCount(Object obj); // ��ü �� �� or �˻��� �� ��

	List<UsedBoardVO> getList(Object obj); // ��ü �� or �˻��� �� ����Ʈ

	void insertArticle(UsedBoardVO usedBoardVo); // �� �Է�

	UsedBoardVO getArticle(Integer num); // �� ��������

	void updateArticle(UsedBoardVO usedBoardVO); // �� �Է�

	 

	void deleteArticle(Integer num); // �� ����
}
