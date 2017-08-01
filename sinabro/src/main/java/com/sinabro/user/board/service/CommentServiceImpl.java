package com.sinabro.user.board.service;

import java.util.List;

import com.sinabro.model.CommentVO;
import com.sinabro.user.board.dao.CommentDAO;

public class CommentServiceImpl implements CommentService{

	private CommentDAO dao;
	
	
	public void setDao(CommentDAO dao) {
		this.dao = dao;
	}

	
	@Override
	public int insertComment(CommentVO vo) {
		// TODO Auto-generated method stub
		return dao.insertComment(vo);
	}

	@Override
	public List<CommentVO> getComment(int num) {
		// TODO Auto-generated method stub
		return dao.getComment(num);
	}

}
