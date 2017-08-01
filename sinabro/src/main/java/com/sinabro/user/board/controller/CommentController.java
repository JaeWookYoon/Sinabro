package com.sinabro.user.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinabro.model.CommentVO;
import com.sinabro.user.board.service.CommentService;
@Controller
public class CommentController {

	private CommentService commentService;
	
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@RequestMapping(value="insertDat.do",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> insertComment(HttpServletRequest request, @RequestBody CommentVO vo) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		ResponseEntity<Map<String,Object>> entity=null;
		Map<String,Object>map=new HashMap<String,Object>();
		if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			map.put("result",new Integer(2));
			entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}else {
		
		vo.setId((String)session.getAttribute("loginId"));
		int result=commentService.insertComment(vo);
		map.put("result", result);
		try {
			entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		}
		
		return entity;
	}

	@RequestMapping(value="getDat.do",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getCommentList(int num) {
		// TODO Auto-generated method stub
		ResponseEntity<Map<String,Object>>entity=null;
		Map<String,Object>map=new HashMap<String,Object>();
		List<CommentVO>list=commentService.getComment(num);
		map.put("list", list);
		try {
			entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
