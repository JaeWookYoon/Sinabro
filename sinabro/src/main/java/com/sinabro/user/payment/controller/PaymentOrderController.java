package com.sinabro.user.payment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentOrderController {

	
	@RequestMapping(value="orderExec.do",method=RequestMethod.POST)
	public ModelAndView orderExec(HttpServletRequest request) {
		
		
	}
}