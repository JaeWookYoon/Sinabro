package com.sinabro.manager.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.manager.member.service.AddAdminService;
import com.sinabro.model.MemberVO;


@Controller
public class AddAdminController {

	private AddAdminService addAdminService;
	
	
	public void setAddAdminService(AddAdminService addAdminService) {
		this.addAdminService = addAdminService;
	}

	
	@RequestMapping(value="regForm.mustang")
	public String getRegForm() {
		return "member/regForm"; 
	}
	
	@RequestMapping(value="join.mustang",method=RequestMethod.POST)
	public ModelAndView addAdmin(HttpServletRequest request,MemberVO vo) {
	
		ModelAndView model=new ModelAndView();
		String email=request.getParameter("email")+"@"+request.getParameter("emailaddress");
		String phone=request.getParameter("phone")+request.getParameter("phone1")+request.getParameter("phone2");
		vo.setEmail(email); vo.setPhone(phone);
		vo.setAddress1("Manager");
		vo.setAddress2("Manager");
		vo.setZipcode(1);
		vo.setAdmin(1);
		
		int result=addAdminService.addAdmin(vo);
		if(result>0) {
			model.addObject("result",new Integer(1));
			
			model.setViewName("redirect:addProductForm.mustang");
		}else {
			model.addObject("result",new Integer(0));
			model.setViewName("member/regForm");
		}
		return model;
	}
	
	@RequestMapping(value = "check.mustang")
	public String getCheck() {
		return "member/idcheck";
	}

	@RequestMapping(value = "idcheck.mustang", method = RequestMethod.POST) // 아이디 체크파트
	public ModelAndView adminCheckId(@RequestParam("id") String id) {
		int count = 0;
		ModelAndView model = new ModelAndView();

		for (int i = 0; i < id.length(); i++) {
			if ((id.charAt(i) >= '0' && id.charAt(i) <= '9') || (id.charAt(i) >= 'a' && id.charAt(i) <= 'z')
					|| (id.charAt(i) >= 'A' && id.charAt(i) <= 'Z')) {

			} else {
				count++;
			}

		}

		if (count > 0) {
			model.addObject("check", new Integer(0));
			model.setViewName("/member/idcheck");
		} else {
			if (addAdminService.adminCheckId(id)) {
				model.addObject("id", id);
				model.addObject("check", new Integer(1));
				model.setViewName("/member/idcheck");
			} else {
				model.addObject("check", new Integer(2));
				model.setViewName("/member/idcheck");
			}
		}
		return model;
	}
}
