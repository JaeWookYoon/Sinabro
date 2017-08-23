package com.sinabro.manager.member.controller;


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

import com.sinabro.manager.member.service.AdminLoginServiceImpl;
import com.sinabro.model.MemberVO;
import com.sinabro.util.BCrypt;
import com.sinabro.util.SHA256;

@Controller
public class AdminLoginController {

	private AdminLoginServiceImpl adminLoginService;

	public void setAdminLoginService(AdminLoginServiceImpl adminLoginService) {
		this.adminLoginService = adminLoginService;
	}
	@RequestMapping(value="/loginForm.mustang")
	public String getloginForm() {
		return "member/loginForm";
	}
	@RequestMapping(value="/hi.mustang")
	public String getMain() {
		return "main";
	}

	// 02. 로그인 처리
	@RequestMapping(value = "login.mustang", method = RequestMethod.POST)
	public ModelAndView getAdminInfo(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(true);
		Map<String,Object>map=new HashMap<String,Object>();
		String ip=request.getRemoteAddr();
		int result=0;
		MemberVO vo=adminLoginService.getAdminInfo(id);
		if(!vo.getId().equals(null)) {//아이디값이 존재
			SHA256 sha=SHA256.getInsatnce();
			String sh=sha.getString(password.getBytes());
			if(BCrypt.checkpw(sh, vo.getPassword())) {
				map.put("id", id);map.put("ip",ip);
				if(vo.getIp()==null||vo.getIp().equals(null)) {
					result=adminLoginService.updateIp(map);
					}else {
						result=adminLoginService.updateIp(map);
					}
				
				if(vo.getAdmin()==1) {
				session.setAttribute("loginCheck", new Integer(1));
				session.setAttribute("member", vo);
				session.setAttribute("loginId", vo.getId());
				session.setAttribute("loginName", vo.getName());
				session.setAttribute("admin", vo.getAdmin());
				model.setViewName("redirect:hi.mustang");//비번 일치
				}else {
					session.setAttribute("loginCheck", new Integer(1));
					session.setAttribute("loginId", vo.getId());
					session.setAttribute("userSecure",vo.getPassword());
					session.setAttribute("member", vo);
					session.setAttribute("loginName", vo.getName());
					session.setAttribute("point", vo.getPoint());
					session.setAttribute("sell", vo.getSell());
					
					session.setAttribute("admin", vo.getAdmin());
					model.setViewName("redirect:hi.do");
				}
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

	// 03. 로그아웃 처리
	@RequestMapping("logout.mustang")
	public ModelAndView adminLogout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		ModelAndView model=new ModelAndView();
		Map<String,Object>map=new HashMap<String,Object>();
		int result=0;
		if(session.getAttribute("loginId")!=null) {
			String id=(String)session.getValue("loginId");
			String ip=null;
			map.put("id", id);map.put("ip", ip);
			result=adminLoginService.deleteIp(map);
			if(result>0) {
			session.invalidate();
			model.setViewName("redirect:hi.mustang");
			}
		}else {
			
		}
			return model;
		
	}
	
	@RequestMapping(value="checkStatus.mustang")
	public ResponseEntity<Map<String,Object>> checkIp(HttpServletRequest request) {
		ResponseEntity<Map<String,Object>>entity=null;
		String ip=request.getRemoteAddr();
		HttpSession session=request.getSession(false);
		Map<String,Object>map=new HashMap<String,Object>();
		if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			map.put("success", true);
			entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}else {
			String now=adminLoginService.checkIp((String)session.getAttribute("loginId"));
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
	@RequestMapping(value="out.mustang")
	public String out(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		session.invalidate();
		return "redirect:hi.mustang";
	}
}