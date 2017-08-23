package com.sinabro.user.usedboard.service;

import java.util.List;

import com.sinabro.model.CommentVO;


public interface UsedDatService {

	int insertDat(CommentVO vo);
	List<CommentVO> getDat(int num);
}
