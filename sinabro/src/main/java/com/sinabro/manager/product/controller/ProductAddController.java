package com.sinabro.manager.product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.manager.product.service.ProductAddService;
import com.sinabro.model.BrandVO;
import com.sinabro.model.ProductListVO;
import com.sinabro.model.ProductVO;
import com.sinabro.util.Product_CodeMake;

@Controller
public class ProductAddController {
	private int count = 0;
	private ProductAddService productService;

	public void setProductService(ProductAddService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "addProductForm.mustang")
	public ModelAndView getForm() {
		ModelAndView model=new ModelAndView();
		List<BrandVO> vo=productService.getBrand();
		model.addObject("list", vo);
		model.setViewName("product/productAddForm");
		return model;
	}

	@RequestMapping(value = "addProduct.mustang", method = RequestMethod.POST)
	public ModelAndView addProduct(HttpServletRequest request, ProductVO list) {
		ModelAndView model = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		String uploadPath = "no";
		if (session.getId() == null || session.getId().equals(null)) {

			model.setViewName("redirect:addProductForm.mustang");
		} else {
			if(productService.checkBrand(list.getBrand())) {
				
			count++;
			uploadPath = request.getRealPath("/images/product");
			String code = Product_CodeMake.makeCode() + count;// 제품 코드생성(난수로 생성)+수 증가
			System.out.println(uploadPath);
					
			
			list.setProduct_code(code);//코드 등록
			System.out.println(list.getImgFile());
			int result=productService.addProduct(list, uploadPath);
			if(result==1) {
				model.addObject("success", true);
				model.setViewName("redirect:addProductForm.mustang");
			}else {
				model.addObject("fail", true);
				model.setViewName("redirect:addProductForm.mustang");
			}//들어 가고나서 확인
			}//brand존재 여부 체크
			else {
				model.addObject("brandfail", true);
				model.setViewName("product/productAddForm");
			}
		}
			
		return model;

	}
	@RequestMapping(value="addBrandForm.mustang")
	public ModelAndView getbrandForm() {
		ModelAndView model=new ModelAndView();
		List<BrandVO> vo=productService.getBrand();
		model.addObject("list", vo);
		model.setViewName("product/brandAddForm");
		return model;
	}
	@RequestMapping(value="addBrand.mustang",method=RequestMethod.POST)
	public ModelAndView addBrand(HttpServletRequest request,BrandVO vo){
		ModelAndView model=new ModelAndView();
		int result=0;
		String upload=request.getRealPath("/images/product");
		if(productService.checkBrand(vo.getBrand())) {//brand존재하는 경우
			result=productService.updateBrand(vo,upload);
			if(result>0) {
				model.addObject("brand", vo.getBrand());
				model.addObject("update", true);
				model.setViewName("product/brandAddForm");
			}
		}else {
			
			result=productService.insertBrand(vo,upload);
			if(result>0) {
				model.addObject("success", true);
				model.setViewName("product/brandAddForm");
			}
		}
		return model;
	}
	
	@RequestMapping(value="deleteBrand.mustang")
	public ModelAndView deleteBrand(HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		int result=0;
		String brand=request.getParameter("brand");
		result=productService.deleteBrand(brand);
		Map<String,Object>map=new HashMap<String,Object>();
		if(result>0) {
			model.addObject("success", true);
			model.setViewName("redirect:addBrandForm.mustang");
		}else {
			model.addObject("fail", true);
			model.setViewName("redirect:addBrandForm.mustang");
		}
		return model;
	}
}
