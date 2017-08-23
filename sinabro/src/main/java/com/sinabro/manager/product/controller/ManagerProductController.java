package com.sinabro.manager.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.manager.product.service.ManagerProductService;
import com.sinabro.model.BrandVO;
import com.sinabro.model.ProductVO;
import com.sinabro.util.Paging;

@Controller
public class ManagerProductController {

	private ManagerProductService managerProductService;
	
	
	public void setManagerProductService(ManagerProductService managerProductService) {
		this.managerProductService = managerProductService;
	}


	@RequestMapping(value="productList.mustang",method=RequestMethod.GET)
	public ModelAndView getProductList(HttpServletRequest request) {
		String pageNum="";
		ModelAndView model=new ModelAndView();
		Paging page=new Paging();
		List<ProductVO>list=null;
		Map<String,Object>map=new HashMap<String,Object>();
		HttpSession session=request.getSession();
		int currentPage=0;
		try {
		if(request.getParameter("pageNum")==null||request.getParameter("pageNum").equals(null)) {
			pageNum="1";
		}else {
			pageNum=request.getParameter("pageNum");
			
		}
		currentPage=Integer.parseInt(pageNum);
		if(request.getParameter("brand")==null||request.getParameter("brand").equals(null)||request.getParameter("brand")==""||request.getParameter("brand").equals("")) {
			map.put("brand", "ALL");
			session.setAttribute("branda", "ALL");
		}else {
			map.put("brand",  request.getParameter("brand"));
			BrandVO vo=managerProductService.getBrand(request.getParameter("brand"));
			model.addObject("brand", vo);
			session.setAttribute("branda", request.getParameter("brand"));
		}
		if(request.getParameter("category")==null||request.getParameter("category").equals(null)||request.getParameter("category")==""||request.getParameter("category").equals("")) {
			map.put("category","ALL");
			session.setAttribute("categorya", "ALL");
		}else {
			map.put("category", request.getParameter("category"));
			session.setAttribute("categorya", request.getParameter("category"));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		int listCount=managerProductService.getListCount(map);
		page.setPaging(20,5,listCount,currentPage);//paging√≥∏Æ
		
		int startNum=page.getWriting_Start();
		int endNum=page.getWriting_End();
		map.put("startRow", startNum);map.put("endRow", endNum);
		list=managerProductService.getProductList(map);
		model.addObject("brandAll", managerProductService.getBrand());
		for(int i=0;i<list.size();i++) {
			String img=list.get(i).getMainImg().substring(0, list.get(i).getMainImg().length()-1);
			String[]imgs=img.split(";");
			for(String l:imgs) {
				list.get(i).setMainImg(l);
			}
			
			System.out.println(list.get(i));
		}
		
		int endPage=page.getPage_End();
		if(endPage>=page.getPage_Count()) {
			endPage=page.getPage_Count();
		}
		boolean next=false;
		if(endPage<page.getPage_Count()) {
			next=true;
		}
		System.out.println(pageNum+"page");
		System.out.println(page.getPageSize() );
		System.out.println(page.getPage_Start()+"start");
		System.out.println(page.getCurrentPage());
		System.out.println(endPage+"end");
		System.out.println(page.isPre());
		System.out.println(next);
		System.out.println(page.getPageBlock());
		int pageCount=page.getPage_Count();
		model.addObject("pageCount", pageCount);
		model.addObject("startPage", page.getPage_Start());
		model.addObject("endPage", endPage);
		model.addObject("startNum", startNum);
		model.addObject("endNum", endNum);
		model.addObject("pageBlock", new Integer(page.getPageBlock()));
		model.addObject("count", page.getCount());
		model.addObject("list", list);
		model.addObject("listCount", list.size());
		model.addObject("pageSize",page.getPageSize());
		model.addObject("pre",page.isPre());
		model.addObject("post",next);
		model.addObject("tdcount",new Integer(1));
		model.setViewName("product/productList");
		
		return model;
	}
	@RequestMapping(value="productContent.mustang",method=RequestMethod.GET)
	public ModelAndView getProductContent(@RequestParam("product_code")String code) {
		ModelAndView model=new ModelAndView();
		ProductVO vo=managerProductService.getProductContent(code);
		String mainImg=vo.getMainImg().substring(0, vo.getMainImg().length()-1);
		String sizea=vo.getSizea().substring(0,vo.getSizea().length()-1);
		String quantitya=vo.getQuantity().substring(0,vo.getQuantity().length()-1);
		String[]img=mainImg.split(";");
		String[]size=sizea.split(";");
		String[]quantity=quantitya.split(";");
		BrandVO bvo=managerProductService.getBrand(vo.getBrand());
		model.addObject("brand", bvo);
		model.addObject("product", vo);
		model.addObject("img", img);model.addObject("size", size);model.addObject("quantity", quantity);
		model.setViewName("product/productContent");
			return model;
	}
	@RequestMapping(value="productUpdateForm.mustang")
	public ModelAndView getUpdateForm(@RequestParam("product_code")String product_code) {
		ModelAndView model=new ModelAndView();
		ProductVO vo=managerProductService.getProductContent(product_code);
		String quan=vo.getQuantity().substring(0, vo.getQuantity().length()-1);
		String[]quantity=quan.split(";");
		String size=vo.getSizea().substring(0,vo.getSizea().length()-1);
		String[]sizea=size.split(";");
		String img=vo.getMainImg().substring(0,vo.getMainImg().length()-1);
		String[]mainimg=img.split(";");
		model.addObject("img", mainimg);
		model.addObject("size", sizea);
		model.addObject("quantity", quantity);
		model.addObject("product", vo);
		model.setViewName("product/productUpdate");
	return model;
	}
	@RequestMapping(value="productUpdate.mustang",method=RequestMethod.POST)
	public ModelAndView updateComplete(HttpServletRequest request,ProductVO vo) {
		int result=0;
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session.getId()==null||session.getId().equals(null)||session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			model.setViewName("redirect:hi.do");
		}else {
		String uploadPath=request.getRealPath("/images/product");
		result=managerProductService.updateProduct(vo, uploadPath);
		
		if(result>0) {
			model.addObject("success", true);
			model.setViewName("redirect:productList.mustang");
		}else {
			model.setViewName("product/productList");
		}
		}
		
		return model;
		
	}
	@RequestMapping(value="deleteProduct.mustang")
	public ModelAndView deleteProduct(HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		HttpSession session=request.getSession(false);
		if(session.getId()==null||session.getId().equals(null)||session.getAttribute("loginId")==null||session.getAttribute("loginId").equals(null)) {
			model.setViewName("redirect:hi.do");
		}else {
		int result=0;
		String code=request.getParameter("product_code");
		result=managerProductService.deleteProduct(code);
		
			if(result>0) {
		
			model.addObject("success", true);
			model.setViewName("redirect:productList.mustang");
		}else {
			model.addObject("fail", true);
			model.setViewName("product/productList");
		}
		}
		return model;
	}
}
