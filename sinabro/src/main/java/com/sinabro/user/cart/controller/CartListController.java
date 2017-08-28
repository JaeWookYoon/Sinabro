package com.sinabro.user.cart.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.CartVO;
import com.sinabro.model.ProductVO;
import com.sinabro.user.cart.service.CartListService;

@Controller
public class CartListController {

	private CartListService cartService;
	
	public void setCartService(CartListService cartService) {
		this.cartService = cartService;
	}

	@RequestMapping(value="cart.do",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> getCartList(HttpServletRequest request,@RequestBody CartVO cart) {
		System.out.println("들어와");
		HttpSession session=request.getSession(false);
		ResponseEntity<Map<String,Object>>entity=null;
		Map<String,Object>map=new HashMap<String,Object>();
		try {
		if(session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)||session.getId()==null||session.getId().equals(null)) {
			map.put("error", true);
			entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}else{
			System.out.println("cart다");
			String id=(String)session.getValue("loginId");
			System.out.println(cart.getProduct_code()+"code");
			System.out.println(cart.getSizea()+"size");
			
			cart.setId(id);
			
			int result=cartService.insertCart(cart);
			if(result>0){
				map.put("success", true);
				entity=new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="Mycart.do")
	public ModelAndView getCartView(HttpServletRequest request) {
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session.getId().equals(null)||session.getId()==null||session.getAttribute("loginId").equals(null)||session.getAttribute("loginId")==null) {
			model.setViewName("redirect:loginForm.do");
		}else {
			String id=(String)session.getValue("loginId");
			List<ProductVO> list=new ArrayList<ProductVO>();
			List<CartVO>cart=cartService.getCart(id);
			for(int i=0;i<cart.size();i++) {
				list.add(cartService.getCartList(cart.get(i).getProduct_code()));//cart순서대로 product를 뽑아내고
			}
			
			for(int i=0;i<list.size();i++) {
				String product=list.get(i).getMainImg().substring(0, list.get(i).getMainImg().length()-1);//cart에 담긴 size를 product에 담는다.
				String [] imgs=product.split(";");
				list.get(i).setSizea(cart.get(i).getSizea());
				list.get(i).setMainImg(imgs[0]);
				
			}
			model.addObject("cart", list);
			model.addObject("count", list.size());
			model.setViewName("cart/cart");
		}
		return model;
	}
	@RequestMapping(value="deleteCart.do")
	public ModelAndView deleteCart(HttpServletRequest request,@RequestParam("product_code")String product_code){
		ModelAndView model=new ModelAndView();
		Map<String,Object>map=new HashMap<String,Object>();
		HttpSession session=request.getSession(false);
		int result=0;
		if(session.getId()==null||session.getId().equals(null)) {
			model.setViewName("redirect:hi.do");
		}else {
			
		map.put("id", session.getValue("loginId"));map.put("product_code", product_code);
		result=cartService.deleteCart(map);
		if(result>0) {
			model.setViewName("redirect:Mycart.do");
		}
		}
		return model;
	}
	
}
