package com.sinabro.user.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.user.member.service.CheckMemberService;

@Controller
public class CheckController {

	private CheckMemberService checkService;

	@RequestMapping(value = "check.do")
	public String getCheck() {
		return "member/idcheck";
	}

	@RequestMapping(value = "idcheck.do", method = RequestMethod.POST)//아이디 체크파트
	public ModelAndView checkId(@RequestParam("id")String id) {
		int count=0;
		ModelAndView model=new ModelAndView();
		
			for (int i = 0; i < id.length(); i++) {
				if ((id.charAt(i) >= '0' && id.charAt(i) <= '9')||(id.charAt(i) >= 'a' && id.charAt(i) <= 'z')||(id.charAt(i) >= 'A' && id.charAt(i) <= 'Z')){  

				}else {
					count++;
				}
					
			}
					
			if(count>0) {
				model.addObject("check", new Integer(0));
				model.setViewName("/member/idcheck");
			}else {
			if (checkService.checkId(id)) {
				model.addObject("id", id);
				model.addObject("check", new Integer(1));
				model.setViewName("/member/idcheck");
			}else {
				model.addObject("check", new Integer(2));
				model.setViewName("/member/idcheck");
			}
			}
			return model;
		}
			

	
	public void setCheckService(CheckMemberService checkService) {
		this.checkService = checkService;
	}
}
