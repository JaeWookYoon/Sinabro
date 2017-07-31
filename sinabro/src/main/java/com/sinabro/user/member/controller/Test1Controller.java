package com.sinabro.user.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test1Controller {

	@RequestMapping(value="test1.do")
	public String getTest1() {
		return "test1";
	}
}
