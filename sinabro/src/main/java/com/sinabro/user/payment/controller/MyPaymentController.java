package com.sinabro.user.payment.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.MyPaymentVO;
import com.sinabro.user.payment.service.MyPaymentService;

@Controller
public class MyPaymentController {

	private MyPaymentService myPaymentService;

	public void setMyPaymentService(MyPaymentService myPaymentService) {
		this.myPaymentService = myPaymentService;
	}
	
	@RequestMapping(value="MyShopping.do")
	public ModelAndView getMyShop(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		ModelAndView model=new ModelAndView();
		if(session.getId()==null||session.getId().equals(null)||session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			model.setViewName("redirect:loginForm.do");
		}else {
			String id=(String)session.getValue("loginId");
			List<MyPaymentVO>list=myPaymentService.getComplpeInfo(id);
			for(int i=0;i<list.size();i++) {
				String img=list.get(i).getMainimg();
				String [] imgs=img.substring(0, img.length()-1).split(";");
				list.get(i).setMainimg(imgs[0]);
			}
		model.addObject("list", list);
		model.setViewName("userpage/paidProduct");
		}
		return model;
	}
	
}
