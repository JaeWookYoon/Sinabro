package com.sinabro.user.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.CommentVO;

public class CommentDAOImpl implements CommentDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	private String namespace="com.sinabro.user.board.dao.";
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int insertComment(CommentVO vo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(namespace+"insertComment",vo);
	}

	@Override
	public List<CommentVO> getComment(int num) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"getComment", num);
	}

	
	
}
