package com.sinabro.user.member.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.sinabro.model.MemberVO;
import com.sinabro.user.member.service.AddMemberService;


@Controller
public class AddController {

	private AddMemberService addMemberService;
	
	
	public void setAddMemberService(AddMemberService addMemberService) {
		this.addMemberService = addMemberService;
	}
	@RequestMapping(value="policy.do")
	public String getPolicy() {
		return "member/policyForm";
	}

	@RequestMapping(value="/regForm.do")
	public String getRegForm() {
		return "member/regForm"; 
	}
	
	@RequestMapping(value="/join.do",method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request,MemberVO vo) {
		
		
			
			
		ModelAndView model=new ModelAndView();
		String email=request.getParameter("email")+"@"+request.getParameter("emailaddress");
		String phone=request.getParameter("phone")+request.getParameter("phone1")+request.getParameter("phone2");
		vo.setEmail(email); vo.setPhone(phone);
		
		
		int result=addMemberService.addUser(vo);
		if(result>0) {
			model.addObject("result",new Integer(1));
			
			model.setViewName("redirect:hi.do");
		}else {
			model.addObject("result",new Integer(0));
			model.setViewName("member/regForm");
		}
		return model;
	}
}
