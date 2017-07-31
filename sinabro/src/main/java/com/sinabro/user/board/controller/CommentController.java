package com.sinabro.user.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sinabro.model.CommentVO;

public class CommentController {

	
	public ResponseEntity<Map<String,Object>> insertComment(HttpServletRequest request, CommentVO vo) {
		// TODO Auto-generated method stub
		ResponseEntity<Map<String,Object>> entity=null;
		Map<String,Object>map=new HashMap<String,Object>();
		HttpSession session=request.getSession(false);
		if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			map.put("check", false);
			try{
				entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				entity=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
			}
			return entity;
		}else {
			
		}
		return null;
	}

	
	public ResponseEntity<Map<String,Object>> getCommentList(int num) {
		// TODO Auto-generated method stub
		return null;
	}

}
