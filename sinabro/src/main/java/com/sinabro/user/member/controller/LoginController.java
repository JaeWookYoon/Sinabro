package com.sinabro.user.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@RequestMapping(value="/loginForm.do")
	public String getloginForm() {
		return "member/loginForm";
	}
	@RequestMapping(value="/hi.do")
	public String getMain() {
		return "member/mainContent";
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public ModelAndView getUserInfo(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(true);
		MemberVO vo=loginService.getUserInfo(id);
		if(!vo.getId().equals(null)) {//아이디값이 존재
			SHA256 sha=SHA256.getInsatnce();
			String sh=sha.getString(password.getBytes());
			if(BCrypt.checkpw(sh, vo.getPassword())) {
				session.setAttribute("loginCheck", new Integer(1));
				session.setAttribute("member", vo);
				session.setAttribute("loginId", vo.getId());
				session.setAttribute("loginName", vo.getName());
				session.setAttribute("point", vo.getPoint());
				
				model.setViewName("redirect:hi.do");//비번 일치
			}else {
				model.addObject("loginCheck", new Integer(0));
				model.setViewName("member/loginForm");//비번 불일치할 경우
			}
		}else {
			model.addObject("check", new Integer(0));
			model.setViewName("member/loginForm");//아이디 없을때
		}
		return model;	
	}
	@RequestMapping(value="logout.do")
	public ModelAndView getLogout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		ModelAndView model=new ModelAndView();
		if(session.getAttribute("loginId")!=null) {
			session.invalidate();
			model.setViewName("redirect:hi.do");
		}else {
			
		}
			return model;
		
	}
}
		
		
		
