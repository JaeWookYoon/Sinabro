package com.sinabro.user.usedboard.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.sinabro.model.CommentVO;
import com.sinabro.user.usedboard.service.UsedDatService;

@Controller
public class UsedDatController {

	private UsedDatService usedDatService;
	
	
	
	public void setUsedDatService(UsedDatService usedDatService) {
		this.usedDatService = usedDatService;
	}

	@RequestMapping(value="insertUsedDat.do",method=RequestMethod.POST)
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
		System.out.println(vo.getId()+"ID");
		System.out.println(vo.getNum()+"NUM");
		System.out.println(vo.getContent()+"content");
		int result=usedDatService.insertDat(vo);
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

	@RequestMapping(value="/getUsedBoardDat.do")
	public ResponseEntity<Map<String,Object>> getCommentList(@RequestParam("num")int num) {
		// TODO Auto-generated method stub
		System.out.println("µé¾î¿Í");
		ResponseEntity<Map<String,Object>>entity=null;
		Map<String,Object>map=new HashMap<String,Object>();
		List<CommentVO>list=usedDatService.getDat(num);
		System.out.println(list.size()+"NUM");
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
