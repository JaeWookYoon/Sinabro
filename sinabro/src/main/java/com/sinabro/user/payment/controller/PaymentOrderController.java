package com.sinabro.user.payment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.PaymentListVO;
import com.sinabro.model.PaymentVO;
import com.sinabro.user.payment.service.PaymentOrderService;

@Controller
public class PaymentOrderController {

	private PaymentOrderService paymentOrderService;
	
	
	public void setPaymentOrderService(PaymentOrderService paymentOrderService) {
		this.paymentOrderService = paymentOrderService;
	}


	@RequestMapping(value="orderExec.do",method=RequestMethod.POST)
	public ModelAndView orderExec(HttpServletRequest request,PaymentVO payment) throws Exception{
		request.setCharacterEncoding("UTF-8");
		System.out.println("¿Ô´Ù");
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(false);
		int result=0;
		if(session.getId()==null||session.getId().equals(null)||session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			model.setViewName("redirect:hi.do");
		}else {
			System.out.println(session.getAttribute("loginId")+"ID");
			String id=(String)session.getAttribute("loginId");
			for(int i=0;i<payment.getProduct_codea().size();i++) {
				System.out.println(payment.getProduct_codea().get(i));
			}
			payment.setId(id);
			payment.setAddress(payment.getZipcode()+payment.getAddress1()+payment.getAddress2());
			result=paymentOrderService.orderExec(payment);
			if(result>=3) {
				model.addObject("success", true);
				model.setViewName("member/mainContent");
			}if(result==-1) {
				model.addObject("milagefail", true);
				model.setViewName("member/mainContent");
			}
			
			else {
				model.addObject("fail",true);
				model.setViewName("member/mainContent");
			}
		}
		return model;
	}
	@RequestMapping(value="testOrder.do")
	public String testOrder() {
	
		
		
		
		return "order/testOrder";
	}
}
