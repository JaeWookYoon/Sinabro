package com.sinabro.user.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.model.ProductVO;
import com.sinabro.user.product.service.ProductListService;
import com.sinabro.util.Paging;


@Controller
public class ProductListController {

	private ProductListService productListService;
	
	public void setProductListService(ProductListService productListService) {
		this.productListService = productListService;
	}

	@RequestMapping(value="productList.do",method=RequestMethod.GET)
	public ModelAndView getProductList(HttpServletRequest request) {
		int pageNum=0;
		ModelAndView model=new ModelAndView();
		Paging page=new Paging();
		List<ProductVO>list=null;
		Map<String,Object>map=new HashMap<String,Object>();
		try {
		if(request.getParameter("pageNum")==null||request.getParameter("pageNum").equals(null)) {
			pageNum=1;
		}else {
			pageNum=Integer.valueOf(request.getParameter("pageNum"));
		}
		if(request.getParameter("brand")==null||request.getParameter("brand").equals(null)) {
			map.put("brand", "ALL");
		}else {
			map.put("brand",  request.getParameter("brand"));
		}
		if(request.getParameter("category")==null||request.getParameter("category").equals(null)) {
			map.put("category","ALL");
		}else {
			map.put("category", request.getParameter("category"));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		list=productListService.getProductList(map);
		
		for(int i=0;i<list.size();i++) {
			String img=list.get(i).getMainImg().substring(0, list.get(i).getMainImg().length()-1);
			String[]imgs=img.split(";");
			for(String l:imgs) {
				list.get(i).setMainImg(l);
			}
			System.out.println(list.get(i));
		}
		page.setPaging(20,5,list.size(),pageNum);
		int startPage=page.getPage_Start();
		int endPage=page.getPage_End();
		int startNum=page.getWriting_Start();
		int endNum=page.getWriting_End();
		int pageCount=page.getPage_Count();
		model.addObject("pageCount", pageCount);
		model.addObject("startPage", startPage);
		model.addObject("endPage", endPage);
		model.addObject("startNum", startNum);
		model.addObject("endNum", endNum);
		model.addObject("pageBlock", page.getPageBlock());
		model.addObject("count", page.getCount());
		model.addObject("list", list);
		model.addObject("pageSize",page.getPageSize());
		model.addObject("pre",page.isPre());
		model.addObject("post",page.isNext());
		model.addObject("tdcount",new Integer(1));
		model.setViewName("product/productList");
		
		return model;
	}
	
		
		
		
		
}
