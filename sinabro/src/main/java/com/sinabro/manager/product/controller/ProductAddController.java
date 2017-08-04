package com.sinabro.manager.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.sinabro.manager.product.service.ProductAddService;
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
	public String getForm() {
		return "product/productAddForm";
	}

	@RequestMapping(value = "addProduct.mustang", method = RequestMethod.POST)
	public ModelAndView addProduct(HttpServletRequest request, ProductVO list) {
		ModelAndView model = new ModelAndView();
		
		HttpSession session = request.getSession();
		System.out.println(list.getBrand());
		String uploadPath = "no";
		if (session.getId() == null || session.getId().equals(null)) {

			model.setViewName("redirect:addProductForm.mustang");
		} else {
			count++;
			uploadPath = request.getRealPath("/images/product");
			String code = Product_CodeMake.makeCode() + count;// 제품 코드생성(난수로 생성)+수 증가
			System.out.println(uploadPath);
			if (productService.checkBrand(list.getBrand())) {// 브랜드가 없을 때 트루.
			
				productService.insertBrand(list.getBrand());// 브랜드부터 넣기.
			} 
				
			productService.newProductCode(code);// 제품 코드넣기
			list.setProduct_code(code);//코드 등록
			int result=productService.addProduct(list, uploadPath);
			if(result==1) {
				model.addObject("success", true);
				model.setViewName("product/productAddForm");
			}else {
				model.addObject("fail", true);
				model.setViewName("product/productAddForm");
			}//들어 가고나서 확인
		}
			
		return model;

	}

}
