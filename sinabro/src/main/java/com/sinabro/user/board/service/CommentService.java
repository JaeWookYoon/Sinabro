package com.sinabro.user.board.service;

import java.util.List;

import com.sinabro.model.CommentVO;

public interface CommentService {

	int insertComment(CommentVO vo);
	List<CommentVO> getComment(int num);
}
