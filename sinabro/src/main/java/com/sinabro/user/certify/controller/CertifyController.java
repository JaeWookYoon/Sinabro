package com.sinabro.user.certify.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.user.certify.service.CertifyService;

@Controller
public class CertifyController {

	
	private CertifyService certifyService;
	
	
	
	public void setCertifyService(CertifyService certifyService) {
		this.certifyService = certifyService;
	}
	@RequestMapping(value="certifyPage.do")
	public String getCertifyPage(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session.getId()==null||session.getId().equals(null)||session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			return "redirect:loginForm.do";
		}else {
			return "userpage/certifyPage";
		}

	}


	@RequestMapping(value="certify.do",method=RequestMethod.POST)
	public ModelAndView getSmsService(HttpServletRequest request) {
		ModelAndView model=new ModelAndView();
		Map<String,Object>map=new HashMap<String,Object>();
		HttpSession session=request.getSession(false);
		if(session.getId()==null||session.getId().equals(null)||session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			model.setViewName("redirect:loginForm.do");
		}else {
			String phone=request.getParameter("phone1")+request.getParameter("phone2")+request.getParameter("phone3");
			System.out.println(phone);
			map.put("id", session.getAttribute("loginId"));
			map.put("phone", phone);
			String code=certifyService.getSmsService(map);
			if(!code.equals("no")) {
				session.setAttribute("certifyCode", code);
				model.setViewName("userpage/certifycodePage");
			}else {//회원정보와 다른경우
				model.addObject("fail", true);
				model.setViewName("userpage/certifyPage");
			}
		}
		return model;
	}
	@RequestMapping(value="nowTime.do")
	public ResponseEntity<Map<String,Object>>getNowTime(){
		ResponseEntity<Map<String,Object>>entity=null;
		Map<String,Object>map=new HashMap<String,Object>();
		Date date=new Date();
		StringBuilder str=new StringBuilder();
		str.append(date.getYear()+1900);
		str.append(date.getMonth()+1);
		str.append(date.getDate());
		str.append(date.getHours());
		str.append(date.getMinutes());
		str.append(date.getSeconds());
		System.out.println(date.getDate());
		try {
			map.put("now", str.toString());
			entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
