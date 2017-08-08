package com.sinabro.user.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.MemberVO;
import com.sinabro.user.member.service.LoginMemberService;
import com.sinabro.util.BCrypt;
import com.sinabro.util.SHA256;
@Controller
public class LoginController {

	private LoginMemberService loginService;
	
	public void setLoginService(LoginMemberService loginService) {
		this.loginService = loginService;
	}
	@RequestMapping(value="/loginForm.do",method=RequestMethod.GET)
	public String getloginForm() {
		return "member/loginForm";
	}
	@RequestMapping(value="/hi.do",method=RequestMethod.GET)
	public String getMain() {
		return "member/mainContent";
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public ModelAndView getUserInfo(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		ModelAndView model=new ModelAndView();
		String ip=request.getRemoteAddr();
		HttpSession session=request.getSession(false);
		
		MemberVO vo=loginService.getUserInfo(id);
		int result=0;
		Map<String,Object>map=new HashMap<String,Object>();
		try{
			if(!vo.getId().equals(null)) {//아이디값이 존재
		
			SHA256 sha=SHA256.getInsatnce();
			String sh=sha.getString(password.getBytes());
			
			if(BCrypt.checkpw(sh, vo.getPassword())) {//비번 일치
				
				map.put("id", id);
				map.put("ip", ip);
				if(vo.getIp()==null||vo.getIp().equals(null)) {
				result=loginService.updateIp(map);
				}else {
					result=loginService.updateIp(map);
				}
				if(result==1) {
				session.setAttribute("loginCheck", new Integer(1));
				session.setAttribute("member", vo);
				session.setAttribute("loginId", vo.getId());
				session.setAttribute("loginName", vo.getName());
				session.setAttribute("point", vo.getPoint());
				session.setAttribute("sell", vo.getSell());
				session.setAttribute("memberip", ip);
				//로그인 가능상태
				
				model.setViewName("redirect:hi.do");//비번 일치
				}
			}else {
				System.out.println("비번없음");
				model.addObject("check", new Integer(2));
				model.setViewName("member/loginForm");//비번 불일치할 경우
			}
		}else {
			System.out.println("아이디없음");
			model.addObject("check", new Integer(0));
			model.setViewName("member/loginForm");//아이디 없을때
		}
		}catch(Exception e) {
			e.printStackTrace();
			model.addObject("check", new Integer(0));
			model.setViewName("member/loginForm");//아이디 없을때
		}
		return model;	
	}
	@RequestMapping(value="logout.do")
	public ModelAndView getLogout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		ModelAndView model=new ModelAndView();
		Map<String,Object>map=new HashMap<String,Object>();
		if(session.getAttribute("loginId")!=null) {
			String id=(String)session.getAttribute("loginId");
			String ip="0";
			map.put("id", id);map.put("ip", ip);
			int result=loginService.deleteIp(map);
			if(result==1) {
			session.invalidate();
			model.setViewName("redirect:hi.do");
			}
		}else {
			
		}
			return model;
		
	}
	
	@RequestMapping(value="checkStatus.do")
	public ResponseEntity<Map<String,Object>> checkIp(HttpServletRequest request) {
		ResponseEntity<Map<String,Object>>entity=null;
		String ip=request.getRemoteAddr();
		HttpSession session=request.getSession(false);
		Map<String,Object>map=new HashMap<String,Object>();
		if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			map.put("success", true);
			entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}else {
			String now=loginService.checkIp((String)session.getAttribute("loginId"));
			if(!now.equals(ip)) {
				try {
					map.put("fail", true);
					entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
				}catch(Exception e) {
					e.printStackTrace();
					entity=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
				}
			}
		}
		return entity;
	}
	
	@RequestMapping(value="out.do")
	public String out(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		session.invalidate();
		return "redirect:hi.do";
	}
	
}
		
