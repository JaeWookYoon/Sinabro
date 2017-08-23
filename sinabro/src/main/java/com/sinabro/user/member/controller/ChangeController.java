package com.sinabro.user.member.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.MemberVO;
import com.sinabro.user.member.service.ChangeService;
import com.sinabro.util.BCrypt;
import com.sinabro.util.SHA256;

@Controller
public class ChangeController {
	
	private ChangeService changeService;

	public void setChangeService(ChangeService changeService) {
		this.changeService = changeService;
	}
	@RequestMapping(value="updateCheck.do")
	public ModelAndView getUpdateCheckForm(HttpServletRequest request) {
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			model.addObject("loginError",true);
			model.setViewName("userpage/myPage");
		}else {
			
			model.setViewName("userpage/changePage");
		}
		return model;
	}
	
	
	@RequestMapping(value="checkInfo.do",method=RequestMethod.POST)
	public ModelAndView checkUserPw(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView model=new ModelAndView();
		MemberVO vo=new MemberVO();
		HttpSession session=request.getSession(false);
		String password=request.getParameter("passwordone");
		System.out.println(password);
		if(session.getAttribute("loginId").equals(null)||session.getAttribute("loginId")==null) {
			model.addObject("loginError", true);
			model.setViewName("user/myPage");
		}else {
			String id=(String)session.getAttribute("loginId");
			vo=changeService.getUser(id);
		
		 
		System.out.println(vo);
		                                                                                                                                                                                       
		SHA256 sh=SHA256.getInsatnce();
		String pw=sh.getString(password.getBytes());
		if(BCrypt.checkpw(pw, vo.getPassword())){
			model.addObject("check", true);
			model.addObject("vo", vo);
			model.setViewName("userpage/changePage");
			
		}else {
			model.addObject("check",false);
			model.setViewName("userpage/changePage");
		}
		}
		
		return model;
		
	}
	
	
	@RequestMapping(value="updateUserInfo.do",method=RequestMethod.POST)
	public ModelAndView updateMember(MemberVO vo) {
		ModelAndView model=new ModelAndView();
		int result=0;
		result=changeService.updateMember(vo);
		System.out.println(result);
		if(result>0) {
			model.addObject("success", true);
			model.setViewName("userpage/myPage");
		}
		return model;
	}
			
}
