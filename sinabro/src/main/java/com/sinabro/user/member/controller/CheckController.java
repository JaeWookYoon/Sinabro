package com.sinabro.user.member.controller;

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
		@RequestMapping(value="findForm.do")	
	public String findSomething() {
		return "/member/idPwSearchForm";
	}
	@RequestMapping(value="codeForm.do")
	public String checkCode() {
		return "member/checkCode";
	}
		@RequestMapping(value="findId.do",method=RequestMethod.POST)
	public ModelAndView findId(HttpServletRequest request) {
		ModelAndView model=new ModelAndView();	
		
			String name=request.getParameter("name");
			String email=request.getParameter("emailone");
		String code=checkService.findId(name, email);
		
		HttpSession session=request.getSession(true);
		
			
		if(!code.equals("NO")) {//코드가 존재할 때 세션에 이름과 이메일 값과 코드를 저장. 코드는 나중에 비교할 때 사용할거임
			session.setAttribute("findName", name);
			session.setAttribute("findEmail", email);
			session.setAttribute("emailCode", code);
			model.addObject("codeId", new Integer(1));
			model.setViewName("member/checkCode");
		}else {//code가 존재하지 않을때
			model.addObject("fail", "BAD");
			model.setViewName("member/idPwSearchForm");
		}
		
		return model;
	}
	@RequestMapping(value="checkIdCode.do",method=RequestMethod.POST)
	public ModelAndView checkCode(HttpServletRequest request) {
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(false);
		String code=request.getParameter("code");
		if(!session.getAttribute("findName").equals(null)) {
			if(session.getAttribute("emailCode").equals(code)) {
				System.out.println(session.getAttribute("findName"));
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("email", session.getAttribute("findEmail"));
			map.put("name", session.getAttribute("findName"));
				List<String> id=checkService.getId(map);
				model.addObject("codech", "y");
				model.addObject("findId", id);
				model.setViewName("/member/checkCode");
			}else {
				model.setViewName("/member/checkCode");
			}
		}else {
			model.setViewName("/member/idPwSearchForm");
		}
		return model;
	}
	@RequestMapping(value="findPw.do",method=RequestMethod.POST)
	public ModelAndView findPw(HttpServletRequest request) {
		String id=request.getParameter("id");
		String email=request.getParameter("emailtwo");
		ModelAndView model=new ModelAndView();
		String code=checkService.findPw(id, email);
		HttpSession session=request.getSession();
		if(!code.equals("NO")) {//코드가 존재할 때 세션에 이름과 이메일 값과 코드를 저장. 코드는 나중에 비교할 때 사용할거임
			session.setAttribute("thisId", id);
			session.setAttribute("findEmail", email);
			session.setAttribute("emailCode", code);
			model.addObject("codePw", new Integer(1));
			model.setViewName("member/checkCode");
		}else {//code가 존재하지 않을때
			model.addObject("fail", "BAD");
			model.setViewName("member/idPwSearchForm");
		}
		
		return model;
	}
	@RequestMapping(value="checkPwCode.do",method=RequestMethod.POST)
	public ModelAndView checkPwCode(HttpServletRequest request) {
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(false);
		String code=request.getParameter("code");
		if(!session.getAttribute("thisId").equals(null)) {
			if(session.getAttribute("emailCode").equals(code)) {
			
				String pw=checkService.changPw((String)session.getAttribute("thisId"));
				model.addObject("codech", "p");
				model.addObject("findPw", pw);
				model.setViewName("/member/checkCode");
			}else {
				model.setViewName("/member/checkCode");
			}
		}else {
			model.setViewName("/member/idPwSearchForm");
		}
		return model;
		
	}
	@RequestMapping(value="getPoint.do")
	public ResponseEntity<Map<String,Object>>getPoint(HttpServletRequest request){
		ResponseEntity<Map<String,Object>>entity=null;
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session=request.getSession(false);
		try {
		if(session.getId()==null||session.getId().equals(null)||session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			map.put("fail", true);
			entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}else {
			String id=(String)session.getValue("loginId");
			int pointa = checkService.getPoint(id);
			String point="Point :"+pointa;
			map.put("success", true);
			map.put("point", point);
			entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.OK);
		}
		return entity;
	}
			
			
	
	public void setCheckService(CheckMemberService checkService) {
		this.checkService = checkService;
	}
}
