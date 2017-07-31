package com.main.sinabro;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinabro.model.MemberVO;

@Controller
public class TestController {
	@RequestMapping(value="test.do",method=RequestMethod.POST)
	public void Test(HttpServletRequest request,MemberVO member) {
		System.out.println(member.getId());
		System.out.println(request.getParameter("id"));
	}
}
