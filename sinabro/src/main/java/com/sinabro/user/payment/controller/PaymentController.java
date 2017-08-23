package com.sinabro.user.payment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.CartVO;
import com.sinabro.model.MemberVO;
import com.sinabro.model.ProductVO;
import com.sinabro.user.payment.service.PaymentService;

@Controller
public class PaymentController {

	private PaymentService paymentService;
	
	
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}


	@RequestMapping(value="orderForm.do")
	public ModelAndView getOrderForm(HttpServletRequest request,CartVO cartvo)throws Exception {
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(false);
		try {
		if(session.getId()==null||session.getId().equals(null)||session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			model.setViewName("redirect:hi.do");
		}else {
			String id=(String)session.getAttribute("loginId");
			
			if(cartvo.getProduct_codea()==null||cartvo.getProduct_codea().equals(null)) {
			String product_code=request.getParameter("product_code");
			System.out.println(product_code);
			String size=request.getParameter("sizea");
			System.out.println(id);
			ProductVO productvo=paymentService.getProductOrder(product_code);
			String productimg=productvo.getMainImg().substring(0, productvo.getMainImg().length()-1);
			String[]img=productimg.split(";");
			productvo.setMainImg(img[0]);
			productvo.setSizea(size);
			model.addObject("product", productvo); 
			
			}else {
				List<String>product_code=cartvo.getProduct_codea();
				List<String>size=cartvo.getSizeaa();
				List<ProductVO>product=new ArrayList<ProductVO>();
				for(int i=0;i<product_code.size();i++) {
					product.add(paymentService.getProductOrder(product_code.get(i)));
				}
				for(int i=0;i<product.size();i++) {
					String mainImage=product.get(i).getMainImg().substring(0, product.get(i).getMainImg().length()-1);
					String[]img=mainImage.split(";");
					product.get(i).setMainImg(img[0]);
					product.get(i).setSizea(size.get(i));
				}
				model.addObject("productList", product);
			}
			//member정보 보내기.
			MemberVO vo=paymentService.getMember(id);
			model.addObject("member", vo);
			String phone1=vo.getPhone().substring(0, 3);
			String phone2=vo.getPhone().substring(3,7);
			String phone3=vo.getPhone().substring(7,vo.getPhone().length());
			model.addObject("phone1", phone1);
			model.addObject("phone2", phone2);
			model.addObject("phone3", phone3);
			model.setViewName("order/paymentForm");
		}
		}catch(NullPointerException ne) {
			ne.printStackTrace();
		}
		return model;
	} 
	@RequestMapping(value="callMember.do")
	public ResponseEntity<Map<String,Object>>ab(HttpServletRequest request){
		ResponseEntity<Map<String,Object>>cd=null;
		Map<String,Object>ab= new HashMap<String,Object>();
		try {
			HttpSession session=request.getSession(false);
			if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)||session==null||session.equals(null)) {
				ab.put("x", true);
				cd=new ResponseEntity<Map<String,Object>>(ab,HttpStatus.OK);
			}else {
				ab.put("o", true);
				MemberVO vo=paymentService.getMember((String)session.getAttribute("loginId"));
				String phone1=vo.getPhone().substring(0, 3);
				String phone2=vo.getPhone().substring(3,7);
				String phone3=vo.getPhone().substring(7,vo.getPhone().length());
				ab.put("phone1", phone1);
				ab.put("phone2", phone2);
				ab.put("phone3", phone3);
				ab.put("member",vo);
				cd=new ResponseEntity<Map<String,Object>>(ab,HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			cd=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		return cd;
	}
	
}
