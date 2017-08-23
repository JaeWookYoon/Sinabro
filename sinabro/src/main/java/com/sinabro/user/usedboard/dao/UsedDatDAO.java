package com.sinabro.user.usedboard.dao;

import java.util.List;

import com.sinabro.model.CommentVO;

public interface UsedDatDAO {

	int insertDat(CommentVO vo);
	List<CommentVO> getDat(int num);
}
