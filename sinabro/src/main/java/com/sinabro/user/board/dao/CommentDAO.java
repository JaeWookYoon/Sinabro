package com.sinabro.user.board.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.CommentVO;

public interface CommentDAO {

	int insertComment(CommentVO vo);
	List<CommentVO> getComment(int num);
	
}
